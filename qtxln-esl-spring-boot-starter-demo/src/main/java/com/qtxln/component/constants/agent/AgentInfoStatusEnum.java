package com.qtxln.component.constants.agent;

import lombok.Getter;
import lombok.Setter;

/**
 * 坐席状态
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/20 14:51 下午
 * @since 1.0
 */
public enum AgentInfoStatusEnum {
  /**
   * 就绪
   */
  READY("ready"),
  /**
   * 未就绪
   */
  NOT_READY("not_ready"),
  /**
   * 繁忙
   */
  BUSY("busy"),
  /**
   * 不繁忙
   */
  NOT_BUSY("not_busy"),
  /**
   * 空闲
   */
  IDLE("idle"),
  /**
   * 离线
   */
  OFFLINE("offline"),
  /**
   * 服务
   */
  SERVICES("services"),
  /**
   * 在线
   */
  ONLINE("online"),
  /**
   * 振铃
   */
  RINGING("ringing"),
  /**
   * 通话中
   */
  IN_CALL("in_call"),
  /**
   * 未登录
   */
  NOT_LOGIN("not_login");

  @Getter
  @Setter
  private String name;


  AgentInfoStatusEnum(String name) {
    this.name = name;
  }
}

