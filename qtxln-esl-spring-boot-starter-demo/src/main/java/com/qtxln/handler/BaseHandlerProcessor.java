package com.qtxln.handler;

import com.qtxln.esl.transport.event.EslEvent;
import com.qtxln.component.constants.FreeSwitchEventTypeEnum;
import com.qtxln.component.util.EventHandlerUtils;
import com.qtxln.core.cb.CallBillGenerate;
import com.qtxln.core.monitor.AgentAndQueueMonitor;
import com.qtxln.model.es.ElasticEntity;
import com.qtxln.model.handler.FsEvent;
import com.qtxln.service.es.ElasticSearchService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 处理器
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-11 11:06
 * @since 1.0
 */
@Component
@Slf4j
public class BaseHandlerProcessor {
  private final Lock lock = new ReentrantLock();

  private final ElasticSearchService elasticSearchService;
  private final CallBillGenerate callBillGenerate;
  private final AgentAndQueueMonitor agentAndQueueMonitor;

  public BaseHandlerProcessor(ElasticSearchService elasticSearchService, CallBillGenerate callBillGenerate,
                              AgentAndQueueMonitor agentAndQueueMonitor) {
    this.elasticSearchService = elasticSearchService;
    this.callBillGenerate = callBillGenerate;
    this.agentAndQueueMonitor = agentAndQueueMonitor;
  }

  @Async("eventExecutor")
  public void processor(EslEvent event) {
    lock.lock();
    try {
      // custom事件单独处理
      if (Objects.equals(event.getEventName(), FreeSwitchEventTypeEnum.CUSTOM.toString())) {
        agentAndQueueMonitor.processorCustom(event);
        return;
      }
      ElasticEntity elasticEntity = new ElasticEntity();
      Map<String, String> eventHeaders = event.getEventHeaders();
      EventHandlerUtils.filterData(eventHeaders);
      elasticEntity.setData(eventHeaders);
      elasticSearchService.insertOne("fs_event", elasticEntity);
      FsEvent fsEvent = JSON.parseObject(JSON.toJSONString(eventHeaders), FsEvent.class);
      if (Objects.equals(fsEvent.getEventName(), FreeSwitchEventTypeEnum.CHANNEL_HANGUP_COMPLETE.toString())) {
        callBillGenerate.assemblyObject(fsEvent);
      }
    } finally {
      lock.unlock();
    }
  }

}
