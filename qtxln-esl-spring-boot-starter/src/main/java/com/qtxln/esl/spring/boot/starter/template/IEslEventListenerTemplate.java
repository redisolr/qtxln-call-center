package com.qtxln.esl.spring.boot.starter.template;

import com.qtxln.esl.IEslEventListener;
import com.qtxln.esl.spring.boot.starter.annotation.EslEventName;
import com.qtxln.esl.spring.boot.starter.handler.DefaultEslEventHandler;
import com.qtxln.esl.spring.boot.starter.handler.EslEventHandler;
import com.qtxln.esl.transport.event.EslEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * IEslEventListenerTemplate
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 15:54 下午
 * @since 1.0
 */
@Slf4j
@Component
public class IEslEventListenerTemplate implements IEslEventListener, InitializingBean, ApplicationContextAware {

  private ApplicationContext applicationContext;
  private final Map<String, List<EslEventHandler>> handlerTable = new HashMap<>(16);
  private EslEventHandler defaultEventHandler = new DefaultEslEventHandler();

  @Override
  public void eventReceived(String addr, EslEvent event) {
    handleEslEvent(addr, event);
  }

  @Override
  public void backgroundJobResultReceived(String addr, EslEvent event) {
    handleEslEvent(addr, event);
  }

  private void handleEslEvent(String addr, EslEvent event) {
    String eventName = event.getEventName();
    String subEventName = event.getEventHeaders().get(EslEventHandler.SUB_EVENT_HEADER_KEY);
    if (StringUtils.isNotBlank(subEventName)) {
      subEventName = String.format("%s::%s", eventName, subEventName);
    }

    List<EslEventHandler> subEventHandlers = handlerTable.get(subEventName);
    if (!CollectionUtils.isEmpty(subEventHandlers)) {
      subEventHandlers.forEach(eslEventHandler -> eslEventHandler.handle(addr, event));
    }

    List<EslEventHandler> handlers = handlerTable.get(eventName);
    if (!CollectionUtils.isEmpty(handlers)) {
      handlers.forEach(eventHandler -> eventHandler.handle(addr, event));
      return;
    }
    defaultEventHandler.handle(addr, event);
  }

  @Override
  public void afterPropertiesSet() {
    log.info("IEslEventListener init ...");
    Map<String, EslEventHandler> eventHandlerMap = applicationContext.getBeansOfType(EslEventHandler.class);
    for (EslEventHandler eventHandler : eventHandlerMap.values()) {
      Class<? extends EslEventHandler> eventHandleImpl = eventHandler.getClass();
      EslEventName eventName = eventHandleImpl.getAnnotation(EslEventName.class);
      if (eventName == null) {
        continue;
      }
      String[] values = eventName.value();
      if (values.length > 0) {
        Arrays.stream(values).distinct().forEach(value -> {
          if (StringUtils.isNotBlank(value)) {
            log.info("IEslEventListener add EventName[{}], EventHandler[{}] to tables ...", value, eventHandler.getClass());
            if (StringUtils.equals(EslEventHandler.DEFAULT_ESL_EVENT_HANDLER, value)) {
              defaultEventHandler = eventHandler;
            } else {
              handlerTable.computeIfAbsent(value, k -> new ArrayList<>(4)).add(eventHandler);
            }
          }
        });
      }
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

}

