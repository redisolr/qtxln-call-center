package com.qtxln.component.constants.event;

import lombok.Getter;
import lombok.Setter;

/**
 * custom事件相关枚举
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/09/15 13:39
 * @since 1.0
 */
public enum CustomEventEnum {

  /**
   * Event-Subclass 类型
   */
  CALL_CENTER_INFO("callcenter::info"),
  /**
   * CC-Action agent-status-change
   */
  AGENT_STATUS_CHANGE("agent-status-change"),
  /**
   * CC-Action agent-state-change
   */
  AGENT_STATE_CHANGE("agent-state-change"),
  /**
   * CC-Action members-count
   */
  MEMBERS_COUNT("members-count"),
  /**
   * CC-Action member-queue-start
   */
  MEMBER_QUEUE_START("member-queue-start"),
  /**
   * CC-Action member-queue-end
   */
  MEMBER_QUEUE_END("member-queue-end");


  @Getter
  @Setter
  private String customEvent;

  CustomEventEnum(String customEvent) {
    this.customEvent = customEvent;
  }

}
