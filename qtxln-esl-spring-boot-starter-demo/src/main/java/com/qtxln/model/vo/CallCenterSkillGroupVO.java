package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 技能组VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-02 14:47
 * @since 1.0
 */
@Data
public class CallCenterSkillGroupVO {

  @ApiModelProperty("主键")
  private Long id;

  @ApiModelProperty("技能组名称")
  private String skillGroupName;

  @ApiModelProperty("路由(振铃)策略")
  private String routingStrategy;

  @ApiModelProperty("队列语音(语音文件参数)")
  private String mohSound;

  @ApiModelProperty("播报音乐")
  private String announceSound;

  @ApiModelProperty("播报频率")
  private Integer announceFrequency;

  @ApiModelProperty("录音文件参数(录音文件路径)")
  private String recordTemplate;

  @ApiModelProperty("时基分数(优先级相关的时间积分选项)")
  private String timeBaseScore;

  @ApiModelProperty("最大等待时间(超过时间未被接通将退出callCenter)0为禁用")
  private Integer maxWaitTime;

  @ApiModelProperty("最大等待时间与无代理(超出时间电话会退出callCenter)0为禁用")
  private Integer maxWaitTimeWithNoAgent;

  @ApiModelProperty("拒绝新来电间隔时间(max-wait-time-with-no-agent触发时有效)")
  private Integer maxWaitTimeWithNoAgentTimeReached;

  @ApiModelProperty("梯队匹配(0所有梯队,1匹配规则tier-rule*)")
  private Boolean tierRulesApply;

  @ApiModelProperty("梯队的等待时间(进入下个梯队的时间)")
  private Integer tierRuleWaitSecond;

  @ApiModelProperty("梯队等待级别(0第一个梯队等其余不等,1所有梯队都等)")
  private Boolean tierRuleWaitMultiplyLevel;

  @ApiModelProperty("是否跳过no-agent的梯队(0不跳过,1跳过)")
  private Boolean tierRuleNoAgentNoWait;

  @ApiModelProperty("丢弃后是否允许恢复或者重新进入队列(0否,1是)")
  private Boolean abandonedResumeAllowed;

  @ApiModelProperty("最大放弃时长(丢弃超过此时长,将不可以恢复)")
  private Integer discardAbandonedAfter;

  @ApiModelProperty("描述")
  private String description;

  @ApiModelProperty("坐席数量")
  private Integer agentCount;

  @ApiModelProperty("页码")
  @NotNull(message = "页码不能为空", groups = {GroupQuery.class})
  private Integer pageNum;

  @ApiModelProperty("查询长度")
  @NotNull(message = "查询长度不能为空", groups = {GroupQuery.class})
  private Integer pageSize;

  /**
   * 查询分组
   */
  public interface GroupQuery {
  }

  /**
   * 添加分组
   */
  public interface GroupInsert {
  }

  /**
   * 更新分组
   */
  public interface GroupUpdate {
  }

}
