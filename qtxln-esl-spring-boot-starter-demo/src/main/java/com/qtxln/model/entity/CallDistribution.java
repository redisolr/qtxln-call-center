package com.qtxln.model.entity;

import lombok.Data;

/**
 * 呼叫分布
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-24 17:04
 * @since 1.0
 */
@Data
public class CallDistribution {

  /**
   * 呼叫时间
   */
  private String callTime;

  /**
   * 呼叫数量
   */
  private Long callCount;

}
