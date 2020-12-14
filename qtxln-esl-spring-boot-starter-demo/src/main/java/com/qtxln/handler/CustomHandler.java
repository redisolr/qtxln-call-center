package com.qtxln.handler;

import com.qtxln.esl.spring.boot.starter.annotation.EslEventName;
import com.qtxln.esl.spring.boot.starter.handler.EslEventHandler;
import com.qtxln.esl.transport.event.EslEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * custom event
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/20 20:43 下午
 * @since 1.0
 */
@Slf4j
@EslEventName("CUSTOM")
@Component
public class CustomHandler implements EslEventHandler {

  private final BaseHandlerProcessor baseHandlerProcessor;

  public CustomHandler(BaseHandlerProcessor baseHandlerProcessor) {
    this.baseHandlerProcessor = baseHandlerProcessor;
  }

  @Override
  public void handle(String addr, EslEvent event) {
    baseHandlerProcessor.processor(event);
  }
}

