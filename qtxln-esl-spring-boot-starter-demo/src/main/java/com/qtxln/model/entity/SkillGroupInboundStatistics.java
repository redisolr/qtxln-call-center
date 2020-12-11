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
 * 技能组(队列)每日呼入统计
 * </p>
 *
 * @author 秦腾
 * @since 2020-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SkillGroupInboundStatistics implements Serializable {

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
   * 电话呼入量（振铃次数）
   */
  private Long callsOffered;

  /**
   * 电话应答数（接通次数）
   */
  private Long callsHandled;

  /**
   * 应答率,单位%(电话应答数/电话呼入数)
   */
  private Integer handleRate;

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
   * 总排队时长
   */
  private Long totalQueuingTime;

  /**
   * 最大排队时长
   */
  private Long maxQueuingTime;

  /**
   * 平均排队时长
   */
  private BigDecimal averageQueuingTime;

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
   * 排队放弃量
   */
  private Long abandonedInQueueCount;

  /**
   * 排队超时量
   */
  private Long abandonedInQueueTimeout;

  /**
   * 振铃放弃量
   */
  private Long abandonedByRingCount;

  /**
   * 坐席放弃量
   */
  private Long abandonedByAgentCount;

  /**
   * 创建时间
   */
  private LocalDateTime createTime;

}
