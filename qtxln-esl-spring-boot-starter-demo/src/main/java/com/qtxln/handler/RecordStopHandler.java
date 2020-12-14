package com.qtxln.handler;

import com.qtxln.esl.spring.boot.starter.annotation.EslEventName;
import com.qtxln.esl.spring.boot.starter.handler.EslEventHandler;
import com.qtxln.esl.transport.event.EslEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * RecordStartHandler 录音结束
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/6/12 14:23 下午
 * @since 1.0
 */
@Slf4j
@EslEventName("RECORD_STOP")
@Component
public class RecordStopHandler implements EslEventHandler {

  private final BaseHandlerProcessor baseHandlerProcessor;

  public RecordStopHandler(BaseHandlerProcessor baseHandlerProcessor) {
    this.baseHandlerProcessor = baseHandlerProcessor;
  }

  @Override
  public void handle(String addr, EslEvent event) {
    baseHandlerProcessor.processor(event);
  }
}

