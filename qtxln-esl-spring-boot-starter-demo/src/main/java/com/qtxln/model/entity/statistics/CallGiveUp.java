package com.qtxln.model.entity.statistics;

import lombok.Data;

/**
 * 通话放弃统计
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/1 13:42 下午
 * @since 1.0
 */
@Data
public class CallGiveUp {

  /**
   * 振铃放弃
   */
  private Long ringGiveUp;
  /**
   * 坐席放弃
   */
  private Long agentGiveUp;
  /**
   * 队列放弃
   */
  private Long queueUpGiveUp;
  /**
   * 队列超时
   */
  private Long queueUpTimeout;

}
