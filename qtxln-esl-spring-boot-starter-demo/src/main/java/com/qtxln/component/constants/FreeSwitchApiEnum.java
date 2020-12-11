package com.qtxln.component.constants;

import lombok.Getter;
import lombok.Setter;

/**
 * fs api命令key,对应commands.properties文件中的key.
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/19 9:54 上午
 * @since 1.0
 */
public enum FreeSwitchApiEnum {

  /**
   * 查看每个分机注册的信息
   */
  GET_EXTENSION_INFO("get.extension.info"),
  /**
   * 设置坐席进入 On Break 状态
   */
  SET_AGENT_STATUS_LOGGED_OUT("set.agent.status.logged.out"),
  /**
   * 设置坐席进入 On Break 状态
   */
  SET_AGENT_STATUS_ON_BREAK("set.agent.status.on.break"),
  /**
   * 设置坐席进入 Available 状态
   */
  SET_AGENT_STATUS_AVAILABLE("set.agent.status.available"),
  /**
   * 设置坐席进入 Waiting 状态
   */
  SET_AGENT_STATE_WAITING("set.agent.state.waiting"),
  /**
   * 设置坐席进入 Idle 状态
   */
  SET_AGENT_STATE_IDLE("set.agent.state.idle"),
  /**
   * 设置坐席进入 In a queue call 状态
   */
  SET_AGENT_STATE_QUEUE_CALL("set.agent.state.queue.call"),
  /**
   * 获取坐席列表
   */
  GET_AGENT_LIST("get.agent.list"),
  /**
   * 获取坐席信息
   */
  GET_AGENT_INFO("get.agent.info"),

  /**
   * 接听通话
   */
  UUID_ANSWER("uuid.answer"),
  /**
   *
   */
  UUID_PHONE_EVENT("uuid.phone.event"),
  /**
   * kill掉通话
   */
  UUID_KILL("uuid.kill"),
  /**
   * 拨打
   */
  DIAL("dial"),
  /**
   * 转接
   */
  TRANSFER("transfer"),
  /**
   * 保持
   */
  HOLD("hold"),
  /**
   * 取消保持
   */
  UN_HOLD("unHold"),
  /**
   * lua脚本执行
   */
  LUA_RUN("lua.run");

  @Getter
  @Setter
  private String apiCommand;

  FreeSwitchApiEnum(String apiCommand) {
    this.apiCommand = apiCommand;
  }

}

