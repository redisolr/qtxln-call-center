package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 技能组坐席VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-03 10:31
 * @since 1.0
 */
@Data
public class CallCenterSkillGroupAgentVO {

  @ApiModelProperty("主键")
  private Long id;

  @ApiModelProperty("坐席名称")
  private String agentName;

  @ApiModelProperty("技能组id")
  private Long skillGroupId;

  @ApiModelProperty("分机id")
  private Long extensionId;

  @ApiModelProperty("分机号")
  private String extensionNumber;

  @ApiModelProperty("呼叫超时时间")
  private Integer callTimeOut;

  @ApiModelProperty("类型")
  private String type;

  @ApiModelProperty("最大无应答次数")
  private Integer maxNoAnswer;

  @ApiModelProperty("话后处理时间")
  private Integer wrapUpTime;

  @ApiModelProperty("坐席拒绝后延迟时间")
  private Integer rejectDelayTime;

  @ApiModelProperty("坐席忙延迟时间")
  private Integer busyDelayTime;

  @ApiModelProperty("无应答重试时间")
  private Integer noAnswerDelayTime;

  @ApiModelProperty("等级")
  private Integer level;

  @ApiModelProperty("地位")
  private Integer position;

  @ApiModelProperty("描述")
  private String description;

  @ApiModelProperty("技能组名")
  private String skillGroupName;

  @ApiModelProperty("分机名")
  private String extensionName;

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
