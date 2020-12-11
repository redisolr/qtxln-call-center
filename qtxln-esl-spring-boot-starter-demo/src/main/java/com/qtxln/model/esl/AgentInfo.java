package com.qtxln.model.esl;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 坐席信息
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/18 16:32 下午
 * @since 1.0
 */
@Data
public class AgentInfo {

  @JSONField(alternateNames = "name")
  private String name;
  @JSONField(alternateNames = "system")
  private String system;
  @JSONField(alternateNames = "uuid")
  private String uuid;
  @JSONField(alternateNames = "type")
  private String type;
  @JSONField(alternateNames = "contact")
  private String contact;
  @JSONField(alternateNames = "status")
  private String status;
  @JSONField(alternateNames = "state")
  private String state;
  @JSONField(alternateNames = "max_no_answer")
  private String maxNoAnswer;
  @JSONField(alternateNames = "wrap_up_time")
  private String wrapUpTime;
  @JSONField(alternateNames = "reject_delay_time")
  private String rejectDelayTime;
  @JSONField(alternateNames = "busy_delay_time")
  private String busyDelayTime;
  @JSONField(alternateNames = "no_answer_delay_time")
  private String noAnswerDelayTime;
  @JSONField(alternateNames = "last_bridge_start")
  private String lastBridgeStart;
  @JSONField(alternateNames = "last_bridge_end")
  private String lastBridgeEnd;
  @JSONField(alternateNames = "last_offered_call")
  private String lastOfferedCall;
  @JSONField(alternateNames = "last_status_change")
  private String lastStatusChange;
  @JSONField(alternateNames = "no_answer_count")
  private String noAnswerCount;
  @JSONField(alternateNames = "calls_answered")
  private String callsAnswered;
  @JSONField(alternateNames = "talk_time")
  private String talkTime;
  @JSONField(alternateNames = "ready_time")
  private String readyTime;
  @JSONField(alternateNames = "agentStatus")
  private String agentStatus;


}

