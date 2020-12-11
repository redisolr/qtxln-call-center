package com.qtxln.core.monitor;

import cn.hutool.core.util.StrUtil;
import com.aegis.freeswitch.esl.transport.event.EslEvent;
import com.aegis.fs.client.SocketClient;
import com.aegis.fs.component.constants.agent.AgentInfoEnum;
import com.aegis.fs.component.constants.agent.AgentInfoStatusEnum;
import com.aegis.fs.component.constants.agent.AgentStateEnum;
import com.aegis.fs.component.constants.agent.AgentStatusEnum;
import com.aegis.fs.component.constants.event.CustomEventEnum;
import com.aegis.fs.core.monitor.agent.AgentObserver;
import com.aegis.fs.core.monitor.queue.QueueObserver;
import com.aegis.fs.model.entity.CallCenterSkillGroupAgent;
import com.aegis.fs.model.esl.AgentInfo;
import com.aegis.fs.model.handler.Custom;
import com.aegis.fs.service.CallCenterSkillGroupAgentService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 坐席和队列监控
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 21:51
 * @since 1.0
 */
@Component
@Slf4j
public class AgentAndQueueMonitor {

  /**
   * 排队信息
   */
  public static final Map<String, Integer> QUEUE_UP_MAP = new ConcurrentHashMap<>();

  private final CallCenterSkillGroupAgentService skillGroupAgentService;
  private final Table<String, String, AgentInfo> agentTable = AgentInfoEnum.INSTANCE.getInstance();
  private final AgentInfoSubject agentInfoSubject = new AgentInfoSubject();

  @Autowired
  public AgentAndQueueMonitor(CallCenterSkillGroupAgentService skillGroupAgentService) {
    this.skillGroupAgentService = skillGroupAgentService;
    new AgentObserver(agentInfoSubject);
    new QueueObserver(agentInfoSubject);
  }

  public void processorCustom(EslEvent event) {
    Custom custom = JSON.parseObject(JSON.toJSONString(event.getEventHeaders()), Custom.class);
    if (Objects.equals(custom.getEventSubclass(), CustomEventEnum.CALL_CENTER_INFO.getCustomEvent())) {
      if (Objects.equals(custom.getCcAction(), CustomEventEnum.AGENT_STATUS_CHANGE.getCustomEvent())) {
        CallCenterSkillGroupAgent callCenterSkillGroupAgent = skillGroupAgentService.getSkillGroupNameByAgent(custom.getCcAgent());
        AgentInfo agentInfo = getAgentInfo(callCenterSkillGroupAgent.getSkillGroupName(), custom.getCcAgent());
        if (!Objects.equals(agentInfo.getStatus(), custom.getCcAgentStatus())) {
          agentInfo.setStatus(custom.getCcAgentStatus());
          setAgentStatus(agentInfo);
          agentTable.put(callCenterSkillGroupAgent.getSkillGroupName(), custom.getCcAgent(), agentInfo);
          if (StrUtil.isNotBlank(agentInfo.getAgentStatus())) {
            agentInfoSubject.setAgentTable(agentTable, callCenterSkillGroupAgent);
          }
        }
      } else if (Objects.equals(custom.getCcAction(), CustomEventEnum.AGENT_STATE_CHANGE.getCustomEvent())) {
        CallCenterSkillGroupAgent callCenterSkillGroupAgent = skillGroupAgentService.getSkillGroupNameByAgent(custom.getCcAgent());
        AgentInfo agentInfo = getAgentInfo(callCenterSkillGroupAgent.getSkillGroupName(), custom.getCcAgent());
        if (!Objects.equals(agentInfo.getState(), custom.getCcAgentState())) {
          agentInfo.setState(custom.getCcAgentState());
          setAgentStatus(agentInfo);
          agentTable.put(callCenterSkillGroupAgent.getSkillGroupName(), custom.getCcAgent(), agentInfo);
          if (StrUtil.isNotBlank(agentInfo.getAgentStatus())) {
            agentInfoSubject.setAgentTable(agentTable, callCenterSkillGroupAgent);
          }
        }
      } else if (Objects.equals(custom.getCcAction(), CustomEventEnum.MEMBERS_COUNT.getCustomEvent())) {
        QUEUE_UP_MAP.put(custom.getCcQueue(), Integer.valueOf(custom.getCcCount()));
        SocketClient.sendMessage(custom.getCcQueue(), "QUEUE_UP", QUEUE_UP_MAP.get(custom.getCcQueue()));
      }
    }
  }

  private AgentInfo getAgentInfo(String skillGroupName, String agentName) {
    return agentTable.contains(skillGroupName, agentName) ? agentTable.get(skillGroupName, agentName) : new AgentInfo();
  }


  private void setAgentStatus(AgentInfo agentInfo) {
    if (Objects.equals(agentInfo.getState(), AgentStateEnum.WAITING.getAgentState()) &&
        Objects.equals(agentInfo.getStatus(), AgentStatusEnum.AVAILABLE.getAgentStatus())) {
      agentInfo.setAgentStatus(AgentInfoStatusEnum.READY.getName());
    } else if (Objects.equals(agentInfo.getState(), AgentStateEnum.WAITING.getAgentState()) &&
        Objects.equals(agentInfo.getStatus(), AgentStatusEnum.ON_BREAK.getAgentStatus())) {
      agentInfo.setAgentStatus(AgentInfoStatusEnum.NOT_READY.getName());
    } else if (Objects.equals(agentInfo.getState(), AgentStateEnum.RECEIVING.getAgentState()) &&
        Objects.equals(agentInfo.getStatus(), AgentStatusEnum.AVAILABLE.getAgentStatus())) {
      agentInfo.setAgentStatus(AgentInfoStatusEnum.RINGING.getName());
    } else if (Objects.equals(agentInfo.getState(), AgentStateEnum.IN_A_QUEUE_CALL.getAgentState()) &&
        Objects.equals(agentInfo.getStatus(), AgentStatusEnum.AVAILABLE.getAgentStatus())) {
      agentInfo.setAgentStatus(AgentInfoStatusEnum.IN_CALL.getName());
    } else if (Objects.equals(agentInfo.getStatus(), AgentStatusEnum.LOGGED_OUT.getAgentStatus())) {
      agentInfo.setAgentStatus(AgentInfoStatusEnum.OFFLINE.getName());
    }
  }

  enum QueueInfoEnum {
    /**
     * 单例创建队列Multimap
     */
    INSTANCE;

    private final Multimap<String, Custom> queueMap;

    QueueInfoEnum() {
      queueMap = ArrayListMultimap.create();
    }

    public Multimap<String, Custom> getInstance() {
      return queueMap;
    }

  }

}
