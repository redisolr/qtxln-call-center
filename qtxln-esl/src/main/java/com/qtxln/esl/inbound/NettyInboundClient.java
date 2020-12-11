package com.qtxln.esl.inbound;

import com.qtxln.esl.constant.EslConstant;
import com.qtxln.esl.inbound.handler.InboundChannelHandler;
import com.qtxln.esl.inbound.option.InboundClientOption;
import com.qtxln.esl.transport.CommandResponse;
import com.qtxln.esl.transport.SendMsg;
import com.qtxln.esl.transport.message.EslMessage;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

/**
 * NettyInboundClient
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:54 下午
 * @since 1.0
 */
public class NettyInboundClient extends AbstractInboundClient{

  /**
   * <p>Constructor for NettyInboundClient.</p>
   *
   * @param option a {@link com.qtxln.esl.inbound.option.InboundClientOption} object.
   */
  public NettyInboundClient(InboundClientOption option) {
    super(option);
  }

  /** {@inheritDoc} */
  @Override
  public EslMessage sendSyncApiCommand(String addr, String command, String arg) {

    InboundChannelHandler handler = getAuthedHandler(addr);
    StringBuilder sb = new StringBuilder();
    if (command != null && !command.isEmpty()) {
      sb.append("api ");
      sb.append(command);
    }
    if (arg != null && !arg.isEmpty()) {
      sb.append(' ');
      sb.append(arg);
    }
    return handler.sendSyncSingleLineCommand(sb.toString());
  }

  @Override
  public EslMessage sendSyncApiCommand(String addr, String command) {
    return this.sendSyncApiCommand(addr, command, null);
  }

  @Override
  public String sendSyncApiCommandReturnBody(String addr, String command, String arg) {
    EslMessage eslMessage = this.sendSyncApiCommand(addr, command, arg);
    return StringUtils.join(eslMessage.getBodyLines(), "\n");
  }

  @Override
  public String sendSyncApiCommandReturnBody(String addr, String command) {
    EslMessage eslMessage = this.sendSyncApiCommand(addr, command);
    return StringUtils.join(eslMessage.getBodyLines(), "\n");
  }

  /** {@inheritDoc} */
  @Override
  public void sendSyncApiCommand(String addr, String command, String arg, Consumer<EslMessage> consumer) {
    publicExecutor.execute(() -> {
      EslMessage msg = sendSyncApiCommand(addr, command, arg);
      if (consumer != null) {
        consumer.accept(msg);
      }
    });
  }

  /** {@inheritDoc} */
  @Override
  public String sendAsyncApiCommand(String addr, String command, String arg) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    StringBuilder sb = new StringBuilder();
    if (command != null && !command.isEmpty()) {
      sb.append("bgapi ");
      sb.append(command);
    }
    if (arg != null && !arg.isEmpty()) {
      sb.append(' ');
      sb.append(arg);
    }

    return handler.sendAsyncCommand(sb.toString());

  }

  /** {@inheritDoc} */
  @Override
  public void sendAsyncApiCommand(String addr, String command, String arg, Consumer<String> consumer) {
    publicExecutor.execute(() -> {
      String msg = sendAsyncApiCommand(addr, command, arg);
      if (consumer != null) {
        consumer.accept(msg);
      }
    });

  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse setEventSubscriptions(String addr, String format, String events) {
    if (!StringUtils.equals(format, EslConstant.PLAIN)) {
      throw new IllegalStateException("Only 'plain' event format is supported at present");
    }
    InboundChannelHandler handler = getAuthedHandler(addr);

    StringBuilder sb = new StringBuilder();
    sb.append("event ");
    sb.append(format);
    if (events != null && !events.isEmpty()) {
      sb.append(' ');
      sb.append(events);
    }
    EslMessage response = handler.sendSyncSingleLineCommand(sb.toString());
    return new CommandResponse(sb.toString(), response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse cancelEventSubscriptions(String addr) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    EslMessage response = handler.sendSyncSingleLineCommand("noevents");
    return new CommandResponse("noevents", response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse addEventFilter(String addr, String eventHeader, String valueToFilter) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    StringBuilder sb = new StringBuilder();
    if (eventHeader != null && !eventHeader.isEmpty()) {
      sb.append("filter ");
      sb.append(eventHeader);
    }
    if (valueToFilter != null && !valueToFilter.isEmpty()) {
      sb.append(' ');
      sb.append(valueToFilter);
    }
    EslMessage response = handler.sendSyncSingleLineCommand(sb.toString());

    return new CommandResponse(sb.toString(), response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse deleteEventFilter(String addr, String eventHeader, String valueToFilter) {
    InboundChannelHandler handler = getAuthedHandler(addr);

    StringBuilder sb = new StringBuilder();
    if (eventHeader != null && !eventHeader.isEmpty()) {
      sb.append("filter delete ");
      sb.append(eventHeader);
    }
    if (valueToFilter != null && !valueToFilter.isEmpty()) {
      sb.append(' ');
      sb.append(valueToFilter);
    }
    EslMessage response = handler.sendSyncSingleLineCommand(sb.toString());
    return new CommandResponse(sb.toString(), response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse sendMessage(String addr, SendMsg sendMsg) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    EslMessage response = handler.sendSyncMultiLineCommand(sendMsg.getMsgLines());
    return new CommandResponse(sendMsg.toString(), response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse setLoggingLevel(String addr, String level) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    StringBuilder sb = new StringBuilder();
    if (level != null && !level.isEmpty()) {
      sb.append("log ");
      sb.append(level);
    }
    EslMessage response = handler.sendSyncSingleLineCommand(sb.toString());
    return new CommandResponse(sb.toString(), response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse cancelLogging(String addr) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    EslMessage response = handler.sendSyncSingleLineCommand("nolog");
    return new CommandResponse("nolog", response);
  }

  /** {@inheritDoc} */
  @Override
  public CommandResponse close(String addr) {
    InboundChannelHandler handler = getAuthedHandler(addr);
    EslMessage response = handler.sendSyncSingleLineCommand("exit");
    return new CommandResponse("exit", response);
  }

}

