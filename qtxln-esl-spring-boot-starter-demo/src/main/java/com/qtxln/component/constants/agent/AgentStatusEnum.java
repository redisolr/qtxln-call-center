package com.qtxln.component.constants.agent;

import lombok.Getter;
import lombok.Setter;

/**
 * 坐席状态 Status
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 15:56
 * @since 1.0
 */
public enum AgentStatusEnum {

  /**
   * 退出服务状态
   */
  LOGGED_OUT("Logged Out"),
  /**
   * 可用状态,可以接电话
   */
  AVAILABLE("Available"),
  /**
   * 坐席已登录,但不可以接听电话
   */
  ON_BREAK("On Break");

  @Getter
  @Setter
  private String agentStatus;

  AgentStatusEnum(String agentStatus) {
    this.agentStatus = agentStatus;
  }

}
