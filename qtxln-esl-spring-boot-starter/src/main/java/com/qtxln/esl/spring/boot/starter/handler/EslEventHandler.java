package com.qtxln.esl.spring.boot.starter.handler;

import com.qtxln.esl.transport.event.EslEvent;

/**
 * EslEventHandler
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 16:00 下午
 * @since 1.0
 */
public interface EslEventHandler {

  /**
   * Constant <code>DEFAULT_ESL_EVENT_HANDLER="DEFAULT_ESL_EVENT_HANDLER"</code>
   */
  String DEFAULT_ESL_EVENT_HANDLER = "DEFAULT_ESL_EVENT_HANDLER";

  /**
   * sub event key
   */
  String SUB_EVENT_HEADER_KEY = "Event-Subclass";

  /**
   * <p>handle.</p>
   *
   * @param addr  a {@link String} object.
   * @param event a {@link com.qtxln.esl.transport.event.EslEvent} object.
   */
  void handle(String addr, EslEvent event);

}

