package com.qtxln.component.constants.agent;

import lombok.Getter;
import lombok.Setter;

/**
 * 坐席状态 State
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 15:56
 * @since 1.0
 */
public enum AgentStateEnum {

  /**
   * 等待接受呼叫
   */
  WAITING("Waiting"),
  /**
   * 正在接受呼叫
   */
  RECEIVING("Receiving"),
  /**
   * 当前在一个队列呼叫中
   */
  IN_A_QUEUE_CALL("In a queue call"),
  /**
   * 空闲
   */
  IDLE("Idle");

  @Getter
  @Setter
  private String agentState;

  AgentStateEnum(String agentState) {
    this.agentState = agentState;
  }

}
