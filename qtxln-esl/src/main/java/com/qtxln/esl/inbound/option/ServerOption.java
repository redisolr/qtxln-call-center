package com.qtxln.esl.inbound.option;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ServerOption
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:26 下午
 * @since 1.0
 */
@Data
@Accessors(fluent = true)
public class ServerOption {

  private final String host;
  private final int port;
  private int timeoutSeconds;
  private String password;

  private ConnectState state = ConnectState.INIT;

  private int connectTimes = 0;

  public String addr() {
    return host + ":" + port;
  }

  public void addConnectTimes() {
    connectTimes++;
  }


}

