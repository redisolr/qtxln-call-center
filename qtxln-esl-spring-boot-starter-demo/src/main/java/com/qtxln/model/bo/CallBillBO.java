package com.qtxln.model.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 话单BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/28 12:13 下午
 * @since 1.0
 */
@Data
public class CallBillBO {

  /**
   * id
   */
  private Long id;
  /**
   * 主叫号码
   */
  private String callerNumber;
  /**
   * 被叫号码
   */
  private String calledNumber;
  /**
   * 呼叫类型
   */
  private String callType;
  /**
   * 拨打时间
   */
  private LocalDateTime callTime;
  /**
   * 挂断原因
   */
  private String hangupCause;
  /**
   * 挂断原因含义
   */
  private String hangupCauseStr;
  /**
   * 总时长
   */
  private Integer totalTime;
  /**
   * 通话时长
   */
  private Integer talkTime;
  /**
   * 满意度
   */
  private String satisfaction;
  /**
   * 坐席
   */
  private String agent;
  /**
   * 技能组
   */
  private String skillGroup;

  private Integer pageNum;

  private Integer pageSize;

}

