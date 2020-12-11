package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 话单统计
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CallBillStatistics extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -6090465650734364928L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
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

  /**
   * 通话时长
   */
  private Long talkTime;

  /**
   * 振铃时长
   */
  private Long ringingTime;

  /**
   * 排队时长
   */
  private Long queuingTime;

}
