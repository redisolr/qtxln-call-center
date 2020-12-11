package com.qtxln.component.constants.call;

import lombok.Getter;
import lombok.Setter;

/**
 * 满意度
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/14 17:47 下午
 * @since 1.0
 */
public enum SatisfactionEnum {

  /**
   * 非常满意
   */
  VERY_SATISFIED("非常满意"),
  /**
   * 满意
   */
  SATISFIED("满意"),
  /**
   * 不满意
   */
  NOT_SATISFIED("不满意"),
  /**
   * 未评价
   */
  NOT_EVALUATED("未评价");

  @Getter
  @Setter
  private String sf;

  SatisfactionEnum(String sf) {
    this.sf = sf;
  }

}
