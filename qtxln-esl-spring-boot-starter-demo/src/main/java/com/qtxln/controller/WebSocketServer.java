package com.qtxln.controller;

import com.qtxln.component.constants.websocket.WebsocketConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/2 00:12 上午
 * @since 1.0
 */
@ServerEndpoint(value = "/api/v1/monitor-fs-service")
@Component
@Slf4j
public class WebSocketServer extends BaseController {

  /**
   * 统计在线人数
   */
  private static final AtomicInteger ONLINE_COUNT = new AtomicInteger(0);

  @OnClose
  public void onClose(Session session) {
    int cnt = ONLINE_COUNT.decrementAndGet();
    WebsocketConstants.WEB_SOCKET_SET.remove(session);
    log.info("断开连接, Session Id: {}, 当前连接数: {}", session.getId(), cnt);
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    log.error("发生错误: {}, Session Id: {}", throwable.getMessage(), session.getId());
  }

  @OnMessage
  public void onMessage(Session session, String message) {
    log.info("接受到客户端的消息, Session Id: {}, 消息: {}", session.getId(), message);
  }

  @OnOpen
  public void onOpen(Session session) {
    int cnt = ONLINE_COUNT.incrementAndGet();
    log.info("连接成功, Session Id: {}, 当前连接数: {}", session.getId(), cnt);
    WebsocketConstants.WEB_SOCKET_SET.add(session);
  }

  private void sendMessage(Session session, String content) {
    session.getAsyncRemote().sendText(content);
  }

}
