package com.qtxln.esl.spring.boot.starter.properties;

import lombok.Data;

/**
 * ServerProperties
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 15:56 下午
 * @since 1.0
 */
@Data
public class ServerProperties {

  private String host;
  private int port;
  private int timeoutSeconds;
  private String password;

}

