package com.qtxln.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 坐席状态记录表
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AgentStateRecord extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -2326770620359476900L;

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

}
