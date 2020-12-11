package com.qtxln.model.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 坐席数据
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@Data
public class AgentBasicsDataBO implements Serializable {

  private static final long serialVersionUID = 5182576439410734913L;

  /**
   * 主键
   */
  private Long id;

  /**
   * 坐席当前状态
   */
  private String agentState;

  /**
   * 坐席名称
   */
  private String agentName;

  /**
   * 总登录时长(单位:秒)
   */
  private Long totalLoggedInTime;

  /**
   * 总未就绪时长(单位:秒)
   */
  private Long totalBreakTime;

  /**
   * 最大未就绪时长(单位:秒)
   */
  private Long maxBreakTime;

  /**
   * 总就绪时长(单位:秒)
   */
  private Long totalReadyTime;

  /**
   * 最大就绪时长(单位:秒)
   */
  private Long maxReadyTime;

  /**
   * 平均就绪时长(单位:秒)
   */
  private BigDecimal averageReadyTime;

  /**
   * 总电话接待量
   */
  private Long totalCalls;

  /**
   * 总振铃时长(单位:秒)
   */
  private Long totalRingTime;

  /**
   * 最大振铃时长(单位:秒)
   */
  private Long maxRingTime;

  /**
   * 平均振铃时长(单位:秒)
   */
  private BigDecimal averageRingTime;

  /**
   * 总通话时长(单位:秒)
   */
  private Long totalTalkTime;

  /**
   * 最大通话时长(单位:秒)
   */
  private Long maxTalkTime;

  /**
   * 平均通话时长(单位:秒)
   */
  private BigDecimal averageTalkTime;

  /**
   * 总话后处理时长(单位:秒)
   */
  private Long totalWorkTime;

  /**
   * 最大话后处理时长(单位:秒)
   */
  private Long maxWorkTime;

  /**
   * 平均话后处理时长(单位:秒)
   */
  private Long averageWorkTime;

  /**
   * 坐席id
   */
  private Long agentId;

  /**
   * 未就绪次数
   */
  private Integer breakCount;

  /**
   * 就绪次数
   */
  private Integer readyCount;

  /**
   * 振铃次数
   */
  private Integer ringCount;

  /**
   * 技能组名称
   */
  private String skillGroupName;

  private Long skillGroupId;

  private Integer pageNum;

  private Integer pageSize;

}
