package com.qtxln.esl.spring.boot.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * InboundClientProperties
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 15:56 下午
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "com.aegis.free-switch.esl.inbound")
public class InboundClientProperties {

  private int sndBufSize = 65535;
  private int rcvBufSize = 65535;
  private int workerGroupThread = 8;
  private int publicExecutorThread = 8;
  private int callbackExecutorThread = 8;
  private int defaultTimeoutSeconds = 5;
  private String defaultPassword = "ClueCon";
  private boolean performance = false;
  private long performanceCostTime = 200;
  private List<String> events = new ArrayList<>();
  private List<ServerProperties> servers = new ArrayList<>();

}

