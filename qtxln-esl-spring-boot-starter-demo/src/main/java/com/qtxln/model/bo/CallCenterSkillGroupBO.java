package com.qtxln.model.bo;

import lombok.Data;

/**
 * 技能组BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/02 14:32 下午
 * @since 1.0
 */
@Data
public class CallCenterSkillGroupBO {

  /**
   * 主键
   */
  private Long id;

  /**
   * 技能组名称
   */
  private String skillGroupName;

  /**
   * 路由(振铃)策略
   */
  private String routingStrategy;

  /**
   * 队列语音(语音文件参数)
   */
  private String mohSound;

  /**
   * 播报音乐
   */
  private String announceSound;

  /**
   * 播报频率
   */
  private Integer announceFrequency;

  /**
   * 录音文件参数(录音文件路径)
   */
  private String recordTemplate;

  /**
   * 时基分数(优先级相关的时间积分选项)
   */
  private String timeBaseScore;

  /**
   * 最大等待时间(超过时间未被接通将退出callCenter)0为禁用
   */
  private Integer maxWaitTime;

  /**
   * 最大等待时间与无代理(超出时间电话会退出callCenter)0为禁用
   */
  private Integer maxWaitTimeWithNoAgent;

  /**
   * 拒绝新来电间隔时间(max-wait-time-with-no-agent触发时有效)
   */
  private Integer maxWaitTimeWithNoAgentTimeReached;

  /**
   * 梯队匹配(0所有梯队,1匹配规则tier-rule*)
   */
  private Boolean tierRulesApply;

  /**
   * 梯队的等待时间(进入下个梯队的时间)
   */
  private Integer tierRuleWaitSecond;

  /**
   * 梯队等待级别(0第一个梯队等其余不等,1所有梯队都等)
   */
  private Boolean tierRuleWaitMultiplyLevel;

  /**
   * 是否跳过no-agent的梯队(0不跳过,1跳过)
   */
  private Boolean tierRuleNoAgentNoWait;

  /**
   * 丢弃后是否允许恢复或者重新进入队列(0否,1是)
   */
  private Boolean abandonedResumeAllowed;

  /**
   * 最大放弃时长(丢弃超过此时长,将不可以恢复)
   */
  private Integer discardAbandonedAfter;

  /**
   * 描述
   */
  private String description;

  /**
   * 坐席数量
   */
  private Integer agentCount;

  private Integer pageNum;

  private Integer pageSize;

}
