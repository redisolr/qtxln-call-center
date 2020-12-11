package com.qtxln.component.constants.agent;

import com.qtxln.model.esl.AgentInfo;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * 坐席状态单例实现
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/21 20:51 下午
 * @since 1.0
 */
public enum AgentInfoEnum {

  /**
   * 单例创建坐席Table
   */
  INSTANCE;

  private final Table<String, String, AgentInfo> agentTable;

  AgentInfoEnum() {
    agentTable = HashBasedTable.create();
  }

  public Table<String, String, AgentInfo> getInstance() {
    return agentTable;
  }

}
