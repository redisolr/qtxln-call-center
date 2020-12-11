package com.qtxln.component.constants.call;

import lombok.Getter;
import lombok.Setter;

/**
 * 呼叫详情类型
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/25 13:29 下午
 * @since 1.0
 */
public enum CallDetailTypeEnum {

  /**
   * 内线呼入
   */
  INSIDE_LINE("内线呼入"),
  /**
   * 内线转队列
   */
  INSIDE_QUEUE("内线转队列"),
  /**
   * 内线转接
   */
  INSIDE_TRANS("内线转接"),
  /**
   * 外线呼入
   */
  OUTSIDE_LINE("外线呼入"),
  /**
   * 外线转队列
   */
  OUTSIDE_QUEUE("外线转队列"),
  /**
   * 外线转接
   */
  OUTSIDE_TRANS("外线转接"),
  /**
   * 呼出
   */
  CALL_BOUND("呼出");

  @Getter
  @Setter
  private String callDetail;

  CallDetailTypeEnum(String callDetailType) {
    this.callDetail = callDetailType;
  }

}
