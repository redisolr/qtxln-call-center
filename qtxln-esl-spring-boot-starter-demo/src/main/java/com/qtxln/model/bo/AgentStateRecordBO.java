package com.qtxln.model.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 坐席状态记录表
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@Data
public class AgentStateRecordBO {

  /**
   * 主键
   */
  private Long id;

  /**
   * 坐席id
   */
  private Long agentId;

  /**
   * 坐席名称
   */
  private String agentName;

  /**
   * 坐席状态
   */
  private String agentState;

  /**
   * 持续时间(单位:秒)
   */
  private Long duration;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

  private Integer pageNum;

  private Integer pageSize;




}
