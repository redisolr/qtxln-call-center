package com.qtxln.model.bo;

import lombok.Data;

/**
 * <p>
 * 话单统计
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-23
 */
@Data
public class CallBillStatisticsBO {

  /**
   * 主键
   */
  private Long id;

  /**
   * 进线量
   */
  private Long inComingLineCount;

  /**
   * 转人工量
   */
  private Long inComingQueueCount;

  /**
   * 智能语音量
   */
  private Long intelligentVoiceCount;

  /**
   * 接听量
   */
  private Long answeredByAgentCount;

  /**
   * 回拨量
   */
  private Long outboundCount;

  /**
   * 回拨接听量
   */
  private Long outboundAnsweredCount;

  /**
   * 今日IVR放弃量
   */
  private Long abandonedInContactFlowCount;

  /**
   * 今日队列放弃量
   */
  private Long abandonedInQueueCount;

  /**
   * 队列超时量
   */
  private Long abandonedInQueueTimeout;

  /**
   * 振铃放弃量
   */
  private Long abandonedByRingCount;

  /**
   * 今日坐席放弃量
   */
  private Long abandonedByAgentCount;

}
