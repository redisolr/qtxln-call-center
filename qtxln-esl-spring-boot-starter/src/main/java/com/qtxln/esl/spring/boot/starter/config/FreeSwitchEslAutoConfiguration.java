package com.qtxln.esl.spring.boot.starter.config;

import com.qtxln.esl.IEslEventListener;
import com.qtxln.esl.InboundClient;
import com.qtxln.esl.inbound.option.InboundClientOption;
import com.qtxln.esl.inbound.option.ServerOption;
import com.qtxln.esl.spring.boot.starter.properties.InboundClientProperties;
import com.qtxln.esl.spring.boot.starter.template.IEslEventListenerTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FreeSwitchEslAutoConfiguration
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 15:54 下午
 * @since 1.0
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({InboundClientProperties.class})
@ConditionalOnClass(InboundClient.class)
public class FreeSwitchEslAutoConfiguration {

  private InboundClientProperties properties;

  @Autowired
  public void setProperties(InboundClientProperties properties) {
    this.properties = properties;
  }

  /**
   * <p>listener.</p>
   *
   * @return a {@link com.qtxln.esl.IEslEventListener} object.
   */
  @Bean
  @ConditionalOnMissingBean(IEslEventListener.class)
  public IEslEventListener listener() {
    return new IEslEventListenerTemplate();
  }

  /**
   * <p>inboundClient.</p>
   *
   * @param listener a {@link com.qtxln.esl.IEslEventListener} object.
   * @return a {@link com.qtxln.esl.InboundClient} object.
   */
  @Bean(initMethod = "start", destroyMethod = "shutdown")
  @ConditionalOnMissingBean(InboundClient.class)
  public InboundClient inboundClient(@Autowired IEslEventListener listener) {
    InboundClientOption option = new InboundClientOption();

    option.sndBufSize(properties.getSndBufSize())
        .rcvBufSize(properties.getRcvBufSize())
        .workerGroupThread(properties.getWorkerGroupThread())
        .publicExecutorThread(properties.getPublicExecutorThread())
        .callbackExecutorThread(properties.getCallbackExecutorThread())
        .defaultTimeoutSeconds(properties.getDefaultTimeoutSeconds())
        .defaultPassword(properties.getDefaultPassword())
        .performance(properties.isPerformance())
        .performanceCostTime(properties.getPerformanceCostTime());

    properties.getServers().forEach(server -> {
      if (StringUtils.isNotBlank(server.getHost()) && server.getPort() > 1) {
        option.addServerOption(new ServerOption(server.getHost(), server.getPort())
            .timeoutSeconds(server.getTimeoutSeconds())
            .password(server.getPassword()));
      }
    });
    properties.getEvents().forEach(event -> {
      if (StringUtils.isNotBlank(event)) {
        option.addEvents(event);
      }
    });

    option.addListener(listener);

    log.info("inboundClient properties : [{}]", properties);
    log.info("inboundClient option : [{}]", option);

    return InboundClient.newInstance(option);
  }
  
}

