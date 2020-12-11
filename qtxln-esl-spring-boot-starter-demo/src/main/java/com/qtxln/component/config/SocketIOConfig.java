package com.qtxln.component.config;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SocketIOConfig
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 10:05 上午
 * @since 1.0
 */
@Configuration
public class SocketIOConfig {
  private final SocketIOProperties socketIoProperties;

  public SocketIOConfig(SocketIOProperties socketIoProperties) {
    this.socketIoProperties = socketIoProperties;
  }

  /**
   * netty-socketIO服务器
   * @return SocketIOServer
   */
  @Bean
  public SocketIOServer socketIoServer() {
    SocketConfig socketConfig = new SocketConfig();
    socketConfig.setTcpNoDelay(true);
    socketConfig.setSoLinger(0);
    com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
    config.setSocketConfig(socketConfig);
    config.setHostname(socketIoProperties.getHost());
    config.setPort(socketIoProperties.getPort());
    config.setBossThreads(socketIoProperties.getBossCount());
    config.setWorkerThreads(socketIoProperties.getWorkCount());
    config.setAllowCustomRequests(socketIoProperties.isAllowCustomRequests());
    config.setUpgradeTimeout(socketIoProperties.getUpgradeTimeout());
    config.setPingTimeout(socketIoProperties.getPingTimeout());
    config.setPingInterval(socketIoProperties.getPingInterval());
    return new SocketIOServer(config);
  }

  /**
   * 用于扫描netty-socketIO的注解，比如 @OnConnect、@OnEvent
   * @return SpringAnnotationScanner
   * */
  @Bean
  public SpringAnnotationScanner springAnnotationScanner() {
    return new SpringAnnotationScanner(socketIoServer());
  }
}

