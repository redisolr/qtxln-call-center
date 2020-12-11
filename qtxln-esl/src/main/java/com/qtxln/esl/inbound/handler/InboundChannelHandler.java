package com.qtxln.esl.inbound.handler;

import com.qtxln.esl.inbound.listener.ChannelEventListener;
import com.qtxln.esl.transport.event.EslEvent;
import com.qtxln.esl.transport.message.EslHeaders;
import com.qtxln.esl.transport.message.EslMessage;
import com.qtxln.esl.util.RemotingUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * InboundChannelHandler
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 13:34 下午
 * @since 1.0
 */
@Slf4j
public class InboundChannelHandler extends SimpleChannelInboundHandler<EslMessage> {

  private static final String MESSAGE_TERMINATOR = "\n\n";
  private static final String LINE_TERMINATOR = "\n";

  private final Lock syncLock = new ReentrantLock();
  private final Queue<SyncCallback> syncCallbacks = new ConcurrentLinkedQueue<>();
  private final ChannelEventListener listener;
  private final ExecutorService publicExecutor;
  private final boolean disablePublicExecutor;
  private Channel channel;
  private String remoteAddr;

  /**
   * <p>Constructor for InboundChannelHandler.</p>
   *
   * @param listener              a {@link com.qtxln.esl.inbound.listener.ChannelEventListener} object.
   * @param publicExecutor        a {@link ExecutorService} object.
   * @param disablePublicExecutor a boolean.
   */
  public InboundChannelHandler(ChannelEventListener listener, ExecutorService publicExecutor, boolean disablePublicExecutor) {
    this.listener = listener;
    this.publicExecutor = publicExecutor;
    this.disablePublicExecutor = disablePublicExecutor;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    super.channelActive(ctx);
    this.channel = ctx.channel();
    this.remoteAddr = RemotingUtil.socketAddress2String(channel.remoteAddress());
    listener.onChannelActive(remoteAddr, this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    super.channelInactive(ctx);
    listener.onChannelClosed(remoteAddr);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void channelRead0(ChannelHandlerContext ctx, EslMessage msg) {
    String contentType = msg.getContentType();
    if (contentType.equals(EslHeaders.Value.TEXT_EVENT_PLAIN) ||
        contentType.equals(EslHeaders.Value.TEXT_EVENT_XML)) {
      //  transform into an event
      EslEvent eslEvent = new EslEvent(msg);
      handleEslEvent(eslEvent);
    } else {
      handleEslMessage(msg);
    }
  }

  private void handleEslMessage(EslMessage message) {
    log.debug("Received message: [{}]", message);
    String contentType = message.getContentType();
    switch (contentType) {
      case EslHeaders.Value.API_RESPONSE:
        log.debug("Api response received [{}]", message);
        Objects.requireNonNull(syncCallbacks.poll()).handle(message);
        break;
      case EslHeaders.Value.COMMAND_REPLY:
        log.debug("Command reply received [{}]", message);
        Objects.requireNonNull(syncCallbacks.poll()).handle(message);
        break;
      case EslHeaders.Value.AUTH_REQUEST:
        log.debug("Auth request received [{}]", message);
        publicExecutor.execute(() -> listener.handleAuthRequest(remoteAddr, this));
        break;
      case EslHeaders.Value.TEXT_DISCONNECT_NOTICE:
        log.debug("Disconnect notice received [{}]", message);
        publicExecutor.execute(() -> listener.handleDisconnectNotice(remoteAddr));
        break;
      default:
        log.warn("Unexpected message content type [{}]", contentType);
        break;
    }
  }

  private void handleEslEvent(EslEvent event) {
    if (disablePublicExecutor) {
      listener.handleEslEvent(remoteAddr, event);
    } else {
      publicExecutor.execute(() -> listener.handleEslEvent(remoteAddr, event));
    }
  }

  /**
   * Synthesise a synchronous command/response by creating a callback object which is placed in
   * queue and blocks waiting for another IO thread to process an incoming {@link com.qtxln.esl.transport.message.EslMessage} and
   * attach it to the callback.
   *
   * @param command single string to send
   * @return the {@link com.qtxln.esl.transport.message.EslMessage} attached to this command's callback
   */
  public EslMessage sendSyncSingleLineCommand(final String command) {
    SyncCallback callback = new SyncCallback();
    syncLock.lock();
    try {
      syncCallbacks.add(callback);
      channel.writeAndFlush(command + MESSAGE_TERMINATOR);
    } finally {
      syncLock.unlock();
    }

    //  Block until the response is available
    return callback.get();
  }

  /**
   * Synthesise a synchronous command/response by creating a callback object which is placed in
   * queue and blocks waiting for another IO thread to process an incoming {@link com.qtxln.esl.transport.message.EslMessage} and
   * attach it to the callback.
   *
   * @param commandLines List of command lines to send
   * @return the {@link com.qtxln.esl.transport.message.EslMessage} attached to this command's callback
   */
  public EslMessage sendSyncMultiLineCommand(final List<String> commandLines) {
    SyncCallback callback = new SyncCallback();
    //  Build command with double line terminator at the end
    StringBuilder sb = new StringBuilder();
    for (String line : commandLines) {
      sb.append(line);
      sb.append(LINE_TERMINATOR);
    }
    sb.append(LINE_TERMINATOR);

    syncLock.lock();
    try {
      syncCallbacks.add(callback);
      channel.writeAndFlush(sb.toString());
    } finally {
      syncLock.unlock();
    }

    //  Block until the response is available
    return callback.get();
  }

  /**
   * Returns the Job UUID of that the response event will have.
   *
   * @param command cmd
   * @return Job-UUID as a string
   */
  public String sendAsyncCommand(final String command) {
    /*
     * Send synchronously to get the Job-UUID to return, the results of the actual
     * job request will be returned by the server as an async event.
     */
    EslMessage response = sendSyncSingleLineCommand(command);
    if (response.hasHeader(EslHeaders.Name.JOB_UUID)) {
      return response.getHeaderValue(EslHeaders.Name.JOB_UUID);
    } else {
      throw new IllegalStateException("Missing Job-UUID header in bgapi response");
    }
  }

  /**
   * <p>close.</p>
   *
   * @return a {@link io.netty.channel.ChannelFuture} object.
   */
  public ChannelFuture close() {
    return channel.close();
  }

  static class SyncCallback {
    private final CountDownLatch latch = new CountDownLatch(1);
    private EslMessage response;

    /**
     * Block waiting for the countdown latch to be released, then return the
     * associated response object.
     *
     * @return msg
     */
    EslMessage get() {
      try {
        log.trace("awaiting latch ... ");
        latch.await();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      log.trace("returning response [{}]", response);
      return response;
    }

    /**
     * Attach this response to the callback and release the countdown latch.
     *
     * @param response res
     */
    void handle(EslMessage response) {
      this.response = response;
      log.trace("releasing latch for response [{}]", response);
      latch.countDown();
    }
  }

}

