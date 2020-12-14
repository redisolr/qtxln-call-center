package com.qtxln.core.monitor.agent;

import com.qtxln.component.util.ApplicationContextUtils;
import com.qtxln.core.monitor.AgentInfoSubject;
import com.qtxln.model.entity.AgentStateRecord;
import com.qtxln.model.entity.CallCenterSkillGroupAgent;
import com.qtxln.model.esl.AgentInfo;
import com.qtxln.service.AgentStateRecordService;
import com.google.common.collect.Table;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 19:39
 * @since 1.0
 */
public class AgentObserver implements Observer {

  public AgentObserver(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void update(Observable observable, Object object) {
    if (observable instanceof AgentInfoSubject) {
      CallCenterSkillGroupAgent callCenterSkillGroupAgent = (CallCenterSkillGroupAgent) object;
      Table<String, String, AgentInfo> agentTable = ((AgentInfoSubject) observable).getAgentTable();
      AgentInfo agentInfo = agentTable.get(callCenterSkillGroupAgent.getSkillGroupName(), callCenterSkillGroupAgent.getAgentName());
      if (agentInfo != null) {
        AgentStateRecord agentStateRecord = new AgentStateRecord();
        agentStateRecord.setAgentId(callCenterSkillGroupAgent.getId());
        agentStateRecord.setAgentName(callCenterSkillGroupAgent.getAgentName());
        agentStateRecord.setAgentState(agentInfo.getAgentStatus());
        AgentStateRecordService agentStateRecordService = ApplicationContextUtils.getBean(AgentStateRecordService.class);
        agentStateRecordService.insertAgentStateRecord(agentStateRecord);
      }
    }
  }

}
