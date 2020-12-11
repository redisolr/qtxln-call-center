package com.qtxln.esl.inbound.listener;

import com.qtxln.esl.inbound.handler.InboundChannelHandler;
import com.qtxln.esl.transport.event.EslEvent;

/**
 * ChannelEventListener
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 13:55 下午
 * @since 1.0
 */
public interface ChannelEventListener {

  /**
   * <p>onChannelActive.</p>
   *
   * @param remoteAddr            a {@link String} object.
   * @param inboundChannelHandler a {@link com.qtxln.esl.inbound.handler.InboundChannelHandler} object.
   */
  void onChannelActive(String remoteAddr, InboundChannelHandler inboundChannelHandler);

  /**
   * <p>onChannelClosed.</p>
   *
   * @param remoteAddr a {@link String} object.
   */
  void onChannelClosed(String remoteAddr);

  /**
   * <p>handleAuthRequest.</p>
   *
   * @param remoteAddr            a {@link String} object.
   * @param inboundChannelHandler a {@link com.qtxln.esl.inbound.handler.InboundChannelHandler} object.
   */
  void handleAuthRequest(String remoteAddr, InboundChannelHandler inboundChannelHandler);

  /**
   * <p>handleEslEvent.</p>
   *
   * @param remoteAddr a {@link String} object.
   * @param event a {@link com.qtxln.esl.transport.event.EslEvent} object.
   */
  void handleEslEvent(String remoteAddr, EslEvent event);

  /**
   * <p>handleDisconnectNotice.</p>
   *
   * @param remoteAddr a {@link String} object.
   */
  void handleDisconnectNotice(String remoteAddr);

}

