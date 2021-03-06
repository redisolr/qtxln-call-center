package com.qtxln.handler;

import com.qtxln.esl.spring.boot.starter.annotation.EslEventName;
import com.qtxln.esl.spring.boot.starter.handler.EslEventHandler;
import com.qtxln.esl.transport.event.EslEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 按键 event
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/9 15:53 下午
 * @since 1.0
 */
@Slf4j
@EslEventName("DTMF")
@Component
public class DtmfHandler implements EslEventHandler {

  private final BaseHandlerProcessor baseHandlerProcessor;

  public DtmfHandler(BaseHandlerProcessor baseHandlerProcessor) {
    this.baseHandlerProcessor = baseHandlerProcessor;
  }

  @Override
  public void handle(String addr, EslEvent event) {
    baseHandlerProcessor.processor(event);
  }
}

