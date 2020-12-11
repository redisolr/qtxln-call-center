package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 坐席信息统计
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/31 18:09 下午
 * @since 1.0
 */
@Data
public class AgentInfoStatisticsVO {

  @ApiModelProperty("呼入总数")
  private Long inBoundCount;
  @ApiModelProperty("呼出总数")
  private Long outBoundCount;
  @ApiModelProperty("通话总数")
  private Long totalCount;
  @ApiModelProperty("总时长")
  private Long totalTime;
  @ApiModelProperty("通话总时长")
  private Long talkTime;
  @ApiModelProperty("振铃总时长")
  private Long ringTime;
  @ApiModelProperty("平均通话时长")
  private BigDecimal averageTalkTime;
  @ApiModelProperty("平均振铃时长")
  private BigDecimal averageRingTime;
  @ApiModelProperty("呼入接听量")
  private Long inBoundConnectedTotal;
  @ApiModelProperty("呼入未接听量")
  private Long inBoundNotConnectedTotal;
  @ApiModelProperty("呼出接听量")
  private Long outBoundConnectedTotal;
  @ApiModelProperty("呼出未接听量")
  private Long outBoundNotConnectedTotal;
  @ApiModelProperty("振铃放弃")
  private Long ringGiveUp;
  @ApiModelProperty("坐席放弃")
  private Long agentGiveUp;
  @ApiModelProperty("队列放弃")
  private Long queueUpGiveUp;
  @ApiModelProperty("队列超时")
  private Long queueUpTimeout;

}
