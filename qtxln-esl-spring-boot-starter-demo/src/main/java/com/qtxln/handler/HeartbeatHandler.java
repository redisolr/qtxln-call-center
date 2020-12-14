package com.qtxln.handler;

import com.qtxln.esl.spring.boot.starter.annotation.EslEventName;
import com.qtxln.esl.spring.boot.starter.handler.EslEventHandler;
import com.qtxln.esl.transport.event.EslEvent;
import com.qtxln.component.util.WebsocketUtils;
import com.qtxln.model.handler.HeartBeatField;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 心跳处理器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 16:14 下午
 * @since 1.0
 */
@Slf4j
@EslEventName("HEARTBEAT")
@Component
public class HeartbeatHandler implements EslEventHandler {

  @Override
  public void handle(String addr, EslEvent event) {
    HeartBeatField heartBeatField = JSON.parseObject(JSON.toJSONString(event.getEventHeaders()), HeartBeatField.class);
    heartBeatField.setUseCpu(new BigDecimal(100).subtract(new BigDecimal(heartBeatField.getIdleCpu()))
        .setScale(1, BigDecimal.ROUND_HALF_UP));
    WebsocketUtils.sendMessageAllSession(JSON.toJSONString(heartBeatField));
  }

}

