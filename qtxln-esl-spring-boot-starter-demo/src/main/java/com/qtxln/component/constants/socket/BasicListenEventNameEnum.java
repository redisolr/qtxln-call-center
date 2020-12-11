package com.qtxln.component.constants.socket;

import lombok.Getter;
import lombok.Setter;

/**
 * BasicListenEventName 监听事件
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 11:41 上午
 * @since 1.0
 */
public enum BasicListenEventNameEnum {
  /**
   * 登录
   */
  LOGIN("login"),
  /**
   * 就绪
   */
  READY("ready"),
  /**
   * 未就绪
   */
  NO_READY("noReady"),
  /**
   * 退出
   */
  LOGOUT("logout"),
  /**
   * 坐席状态
   */
  AGENT_STATUS("agentStatus");


  @Getter
  @Setter
  private String name;


  BasicListenEventNameEnum(String name) {
    this.name = name;
  }

}

