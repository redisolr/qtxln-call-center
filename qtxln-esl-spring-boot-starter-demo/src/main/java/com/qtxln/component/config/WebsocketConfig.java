package com.qtxln.component.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket配置类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/2 22:21 下午
 * @since 1.0
 */
@Configuration
public class WebsocketConfig {
  @Bean
  public ServerEndpointExporter serverEndpointExporter() {
    return new ServerEndpointExporter();
  }
}
