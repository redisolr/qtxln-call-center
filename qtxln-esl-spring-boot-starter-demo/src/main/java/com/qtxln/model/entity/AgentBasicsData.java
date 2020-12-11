package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
public class AgentBasicsData extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -6058955909941212142L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

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
  private BigDecimal averageWorkTime;

  /**
   * 未就绪次数
   */
  @TableField(exist = false)
  private Integer breakCount;

  /**
   * 就绪次数
   */
  @TableField(exist = false)
  private Integer readyCount;

  /**
   * 振铃次数
   */
  @TableField(exist = false)
  private Integer ringCount;

  /**
   * 坐席id
   */
  @TableField(exist = false)
  private Long agentId;

  /**
   * 技能组名称
   */
  @TableField(exist = false)
  private String skillGroupName;

}
