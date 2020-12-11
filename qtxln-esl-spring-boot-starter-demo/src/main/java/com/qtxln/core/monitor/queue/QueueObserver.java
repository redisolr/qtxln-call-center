package com.qtxln.core.monitor.queue;

import com.aegis.fs.client.SocketClient;
import com.aegis.fs.core.monitor.AgentInfoSubject;
import com.aegis.fs.model.core.monitor.QueueMonitor;
import com.aegis.fs.model.entity.CallCenterSkillGroupAgent;
import com.aegis.fs.model.esl.AgentInfo;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

/**
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 19:40
 * @since 1.0
 */
@Slf4j
public class QueueObserver implements Observer {

  public QueueObserver(Observable observable) {
    observable.addObserver(this);
  }

  @Override
  public void update(Observable observable, Object object) {
    if (observable instanceof AgentInfoSubject) {
      CallCenterSkillGroupAgent callCenterSkillGroupAgent = (CallCenterSkillGroupAgent) object;
      Table<String, String, AgentInfo> agentTable = ((AgentInfoSubject) observable).getAgentTable();
      Collection<AgentInfo> agentInfoCollection = agentTable.row(callCenterSkillGroupAgent.getSkillGroupName()).values();
      Map<String, Long> queueInfo = agentInfoCollection.stream().collect(Collectors.groupingBy(AgentInfo::getAgentStatus, Collectors.counting()));
      QueueMonitor queueMonitor = JSON.parseObject(JSON.toJSONString(queueInfo), QueueMonitor.class);
      SocketClient.sendMessage(callCenterSkillGroupAgent.getSkillGroupName(), "QUEUE_INFO", queueMonitor);
    }
  }

}
