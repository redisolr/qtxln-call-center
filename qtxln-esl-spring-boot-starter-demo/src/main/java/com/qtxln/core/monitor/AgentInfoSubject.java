package com.qtxln.core.monitor;

import com.qtxln.model.entity.CallCenterSkillGroupAgent;
import com.qtxln.model.esl.AgentInfo;
import com.google.common.collect.Table;
import lombok.Getter;

import java.util.Observable;

/**
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 19:38
 * @since 1.0
 */
public class AgentInfoSubject extends Observable {
  @Getter
  private Table<String, String, AgentInfo> agentTable;

  public void setAgentTable(Table<String, String, AgentInfo> agentTable, CallCenterSkillGroupAgent callCenterSkillGroupAgent) {
    this.agentTable = agentTable;
    this.setChanged();
    this.notifyObservers(callCenterSkillGroupAgent);
  }

}
