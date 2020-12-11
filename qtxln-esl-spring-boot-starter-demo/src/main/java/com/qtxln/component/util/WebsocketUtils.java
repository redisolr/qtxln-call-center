package com.qtxln.component.util;

import com.aegis.fs.component.constants.websocket.WebsocketConstants;

import javax.websocket.Session;

/**
 * websocket工具类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/2 23:06 下午
 * @since 1.0
 */
public class WebsocketUtils {

  private WebsocketUtils() {}

  /**
   * 发送ws消息
   * @param session Session
   * @param content 消息内容
   */
  public static void sendMessage(Session session, String content) {
    session.getAsyncRemote().sendText(content);
  }

  /**
   * 向所有session发送消息
   * @param content 消息内筒
   */
  public static void sendMessageAllSession(String content) {
    WebsocketConstants.WEB_SOCKET_SET.forEach(session -> sendMessage(session, content));
  }

}
