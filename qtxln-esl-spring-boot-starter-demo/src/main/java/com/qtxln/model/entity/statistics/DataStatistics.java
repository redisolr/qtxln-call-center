package com.qtxln.model.entity.statistics;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 数据统计
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 09:19
 * @since 1.0
 */
@Data
public class DataStatistics {

  /**
   * 今日进线量 今天零点到当前进入呼叫中心的总电话数量
   */
  private Integer inComingLineCount;
  /**
   * 今日转人工量 今天零点到当前进入呼叫中心后，选择转坐席接听的电话数量
   */
  private Integer inComingQueueCount;
  /**
   * 今日接听量 今天零点到当前进入呼叫中心后，选择转人工且被坐席接听的电话数量
   */
  private Integer answeredByAgentCount;
  /**
   * 当前咨询人数 当前和坐席进行通话的电话数量
   */
  private Integer talkingAgents;
  /**
   * 当前排队人数 当前等待坐席接听的电话数量
   */
  private Integer waitingCalls;
  /**
   * 今日IVR放弃量 今天零点到当前进入呼叫中心后，在IVR流程中挂断电话的电话数量
   */
  private Integer abandonedInContactFlowCount;
  /**
   * 今日队列放弃量 今天零点到当前进入呼叫中心后，在排队过程中挂断电话的电话数量
   */
  private Integer abandonedInQueueCount;
  /**
   * 今日坐席放弃量 今天零点到当前进入呼叫中心后，在确认坐席后，等待坐席接听过程中挂断电话的电话数量
   */
  private Integer abandonedByAgentCount;
  /**
   * 坐席利用率 所有坐席有效工作时长（通话、话后处理）/ 所有坐席总在线时长，反映坐席工作的有效性
   */
  private BigDecimal agentUtilization;
  /**
   * 相对满意度 客户对坐席服务的整体满意度
   */
  private BigDecimal relativelySatisfaction;

}
