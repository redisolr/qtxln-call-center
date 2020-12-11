package com.qtxln.model.bo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 坐席信息统计
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/31 18:09 下午
 * @since 1.0
 */
@Data
public class AgentInfoStatisticsBO {

  /**
   * 呼入总数
   */
  private Long inBoundCount;
  /**
   * 呼出总数
   */
  private Long outBoundCount;
  /**
   * 通话总数
   */
  private Long totalCount;
  /**
   * 总时长
   */
  private Long totalTime;
  /**
   * 通话总时长
   */
  private Long talkTime;
  /**
   * 振铃总时长
   */
  private Long ringTime;
  /**
   * 平均通话时长
   */
  private BigDecimal averageTalkTime;
  /**
   * 平均振铃时长
   */
  private BigDecimal averageRingTime;
  /**
   * 呼入接听量
   */
  private Long inBoundConnectedTotal;
  /**
   * 呼入未接听量
   */
  private Long inBoundNotConnectedTotal;
  /**
   * 呼出接听量
   */
  private Long outBoundConnectedTotal;
  /**
   * 呼出未接听量
   */
  private Long outBoundNotConnectedTotal;
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
