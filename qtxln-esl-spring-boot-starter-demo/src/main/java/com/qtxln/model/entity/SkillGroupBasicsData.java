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
 * 技能组基础数据
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SkillGroupBasicsData extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1773142603319772309L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 技能组id
   */
  private Long skillGroupId;

  /**
   * 技能组名称
   */
  private String skillGroupName;

  /**
   * 总电话接待量
   */
  private Long totalCalls;

  /**
   * 总登录时长
   */
  private Long totalLoggedInTime;

  /**
   * 总未就绪时长
   */
  private Long totalBreakTime;

  /**
   * 总就绪时长
   */
  private Long totalReadyTime;

  /**
   * 最大就绪时长
   */
  private Long maxReadyTime;

  /**
   * 总振铃时长
   */
  private Long totalRingTime;

  /**
   * 平均就绪时长
   */
  private BigDecimal averageReadyTime;

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
   * 就绪次数
   */
  @TableField(exist = false)
  private Integer readyCount;

}
