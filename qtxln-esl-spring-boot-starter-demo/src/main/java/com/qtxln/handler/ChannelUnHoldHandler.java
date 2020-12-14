package com.qtxln.handler;

import com.qtxln.esl.spring.boot.starter.annotation.EslEventName;
import com.qtxln.esl.spring.boot.starter.handler.EslEventHandler;
import com.qtxln.esl.transport.event.EslEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 取消保持 event
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/9 15:56 下午
 * @since 1.0
 */
@Slf4j
@EslEventName("CHANNEL_UNHOLD")
@Component
public class ChannelUnHoldHandler implements EslEventHandler {

  private final BaseHandlerProcessor baseHandlerProcessor;

  public ChannelUnHoldHandler(BaseHandlerProcessor baseHandlerProcessor) {
    this.baseHandlerProcessor = baseHandlerProcessor;
  }

  @Override
  public void handle(String addr, EslEvent event) {
    baseHandlerProcessor.processor(event);
  }
}

