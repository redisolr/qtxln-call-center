package com.qtxln.component.constants.socket;

import lombok.Getter;
import lombok.Setter;

/**
 * CallListenEventName 监听事件
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/19 9:52 上午
 * @since 1.0
 */
public enum CallListenEventNameEnum {
  
  /**
   * 接听
   */
  ANSWER("answer"),
  /**
   * 挂断
   */
  HANG_UP("hangUp"),
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
  HOLD("hold");
  @Getter
  @Setter
  private String name;

  CallListenEventNameEnum(String name) {
    this.name = name;
  }

}

