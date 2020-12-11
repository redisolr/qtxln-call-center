package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 技能组坐席表
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CallCenterSkillGroupAgent extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 28256308658547995L;

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
   * 技能组id
   */
  private Long skillGroupId;

  /**
   * 分机id
   */
  private Long extensionId;

  /**
   * 呼叫超时时间
   */
  private Integer callTimeOut;

  /**
   * 类型
   */
  private String type;

  /**
   * 最大无应答次数
   */
  private Integer maxNoAnswer;

  /**
   * 话后处理时间
   */
  private Integer wrapUpTime;

  /**
   * 坐席拒绝后延迟时间
   */
  private Integer rejectDelayTime;

  /**
   * 坐席忙延迟时间
   */
  private Integer busyDelayTime;

  /**
   * 无应答重试时间
   */
  private Integer noAnswerDelayTime;

  /**
   * 等级
   */
  private Integer level;

  /**
   * 地位
   */
  private Integer position;

  /**
   * 描述
   */
  private String description;

  /**
   * 技能组名
   */
  @TableField(exist = false)
  private String skillGroupName;

  /**
   * 分机名
   */
  @TableField(exist = false)
  private String extensionName;

  /**
   * 分机号
   */
  @TableField(exist = false)
  private String extensionNumber;

}
