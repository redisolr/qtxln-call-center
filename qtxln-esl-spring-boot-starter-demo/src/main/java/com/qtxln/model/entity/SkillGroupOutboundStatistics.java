package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 技能组(队列)每日呼出统计
 * </p>
 *
 * @author 秦腾
 * @since 2020-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SkillGroupOutboundStatistics implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 技能组名称
   */
  private String skillGroupName;

  /**
   * 电话拨号量
   */
  private Long callsDialed;

  /**
   * 电话接通量
   */
  private Long callsAnswered;

  /**
   * 接通率(电话接通量/电话拨号量)
   */
  private BigDecimal answerRate;

  /**
   * 总振铃时长
   */
  private Long totalRingTime;

  /**
   * 最大振铃时长
   */
  private Long maxRingTime;

  /**
   * 平均振铃时长(总振铃时长/电话呼入量)
   */
  private BigDecimal averageRingTime;

  /**
   * 总通话时长
   */
  private Long totalTalkTime;

  /**
   * 最大通话时长
   */
  private Long maxTalkTime;

  /**
   * 平均通话时长
   */
  private BigDecimal averageTalkTime;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

}
