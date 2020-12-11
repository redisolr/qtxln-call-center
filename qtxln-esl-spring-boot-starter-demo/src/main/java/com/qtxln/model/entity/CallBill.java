package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 通话清单(话单)
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CallBill extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -1738645506139694530L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String callerNumber;

  /**
   * channel的uuid
   */
  private String uniqueId;

  /**
   * 同一通电话标识
   */
  private String memberSessionId;

  /**
   * 被叫号码
   */
  private String calledNumber;

  /**
   * 拨打时间
   */
  private LocalDateTime callTime;

  /**
   * 接听时间
   */
  private LocalDateTime answerTime;

  /**
   * 挂断时间
   */
  private LocalDateTime hangUpTime;

  /**
   * 呼叫类型
   */
  private String callType;

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
  private Long totalTime;

  /**
   * 通话时长
   */
  private Long talkTime;

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

  /**
   * 是否转接
   */
  @TableField(value = "is_transfer", select = false)
  private Boolean transfer;

  /**
   * 是否有效
   */
  @TableField(value = "is_effective", select = false)
  private Boolean effective;

}
