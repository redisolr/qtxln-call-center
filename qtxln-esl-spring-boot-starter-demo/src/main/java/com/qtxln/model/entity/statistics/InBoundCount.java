package com.qtxln.model.entity.statistics;

import lombok.Data;

/**
 * 呼入统计
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/1 11:58 上午
 * @since 1.0
 */
@Data
public class InBoundCount {

  /**
   * 呼入总量
   */
  private Long inBoundTotal;
  /**
   * 接通量
   */
  private Long connectedTotal;
  /**
   * 未接通量
   */
  private Long notConnectedTotal;

}
