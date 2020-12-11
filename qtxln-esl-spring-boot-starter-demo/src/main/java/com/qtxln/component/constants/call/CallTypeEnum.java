package com.qtxln.component.constants.call;

import lombok.Getter;
import lombok.Setter;

/**
 * 呼叫类型
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/23 17:21 下午
 * @since 1.0
 */
public enum CallTypeEnum {
  /**
   * 呼入
   */
  INBOUND("呼入"),
  /**
   * 呼出
   */
  OUTBOUND("呼出");

  @Getter
  @Setter
  private String ct;

  CallTypeEnum(String callType) {
    this.ct = callType;
  }

}
