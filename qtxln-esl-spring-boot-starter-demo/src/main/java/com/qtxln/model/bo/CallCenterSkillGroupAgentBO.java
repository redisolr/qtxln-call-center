package com.qtxln.model.bo;

import lombok.Data;

/**
 * 技能组坐席BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-03 10:30
 * @since 1.0
 */
@Data
public class CallCenterSkillGroupAgentBO {

  /**
   * 主键
   */
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
   * 技能组名
   */
  private String skillGroupName;

  /**
   * 分机名
   */
  private String extensionName;

  /**
   * 分机号
   */
  private String extensionNumber;

  /**
   * 描述
   */
  private String description;

  private Integer pageNum;

  private Integer pageSize;

}
