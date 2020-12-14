package com.qtxln.esl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.XmlUtil;
import com.qtxln.component.config.FreeSwitchApiTemplate;
import com.qtxln.component.constants.FreeSwitchApiEnum;
import com.qtxln.component.constants.agent.AgentInfoStatusEnum;
import com.qtxln.component.constants.cache.CacheName;
import com.qtxln.component.util.cache.EhCacheUtils;
import com.qtxln.model.esl.AgentInfo;
import com.qtxln.model.esl.Registration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * FreeSwitchOperation
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 14:07 下午
 * @since 1.0
 */
@Component
@Slf4j
public class FreeSwitchOperation {

  private final InboundClient client;
  private final FreeSwitchApiTemplate freeSwitchApiTemplate;

  public FreeSwitchOperation(InboundClient inboundClient, FreeSwitchApiTemplate freeSwitchApiTemplate) {
    this.client = inboundClient;
    this.freeSwitchApiTemplate = freeSwitchApiTemplate;
  }

  /**
   * 登录
   */
  public boolean login(String addr, String extension) {
    String result = client.sendSyncApiCommandReturnBody(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.GET_EXTENSION_INFO.getApiCommand(), extension));
    Map<String, Object> stringObjectMap = XmlUtil.xmlToMap(result);
    String registrations = JSON.toJSONString(stringObjectMap.get("registrations"));
    if (registrations.length() == 6) {
      return false;
    }
    Map<String, String> registration = JSON.parseObject(JSON.toJSONString(stringObjectMap.get("registrations")),
        new TypeReference<Map<String, String>>() {
        });
    JSON.parseObject(JSON.toJSONString(registration), Registration.class);
    // 登录呼叫中心
    AgentInfo agentInfo = agent(addr, extension);
    if (agentInfo != null) {
      log.info("登录，分机号" + extension);
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_ON_BREAK.getApiCommand(), extension));
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_WAITING.getApiCommand(), extension));
      log.info("发送，分机号 On Break, Waiting" + extension);
      agentInfo.setAgentStatus(AgentInfoStatusEnum.NOT_READY.getName());
      EhCacheUtils.put(CacheName.EH_AGENT, extension, agentInfo);
    }
    return true;
  }

  /**
   * 就绪
   */
  public void ready(String addr, String extension) {
    AgentInfo agentInfo = agent(addr, extension);
    if (agentInfo != null) {
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_AVAILABLE.getApiCommand(), extension));
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_WAITING.getApiCommand(), extension));
      agentInfo.setAgentStatus(AgentInfoStatusEnum.READY.getName());
      // 更新就绪状态
      EhCacheUtils.put(CacheName.EH_AGENT, extension, agentInfo);
    }
  }

  /**
   * 未就绪
   */
  public void noReady(String addr, String extension) {
    AgentInfo agentInfo = agent(addr, extension);
    if (agentInfo != null) {
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_ON_BREAK.getApiCommand(), extension));
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_WAITING.getApiCommand(), extension));
      agentInfo.setAgentStatus(AgentInfoStatusEnum.NOT_READY.getName());
      // 更新就绪状态
      EhCacheUtils.put(CacheName.EH_AGENT, extension, agentInfo);
    }
  }

  /**
   * 退出
   */
  public void logout(String addr, String extension) {
    AgentInfo agentInfo = agent(addr, extension);
    if (agentInfo != null) {
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_AVAILABLE.getApiCommand(), extension));
      client.sendSyncApiCommand(addr,
          freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_WAITING.getApiCommand(), extension));
      agentInfo.setAgentStatus(AgentInfoStatusEnum.OFFLINE.getName());
      // 更新就绪状态
      EhCacheUtils.put(CacheName.EH_AGENT, extension, agentInfo);
    }
  }

  /**
   * 接听
   */
  public void answer(String addr, String id, String extension) {
    AgentInfo agentInfo = agent(addr, extension);
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.UUID_ANSWER.getApiCommand(), id));
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.UUID_PHONE_EVENT.getApiCommand(), id));
    agentInfo.setAgentStatus(AgentInfoStatusEnum.IN_CALL.getName());
    // 更新就绪状态
    EhCacheUtils.put(CacheName.EH_AGENT, extension, agentInfo);
  }

  /**
   * 挂断
   */
  public void hungUp(String addr, String id, String extension) {
    AgentInfo agentInfo = agent(addr, extension);
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.UUID_KILL.getApiCommand(), id));
    noReady(addr, extension);
    agentInfo.setAgentStatus(AgentInfoStatusEnum.NOT_READY.getName());
    EhCacheUtils.put(CacheName.EH_AGENT, extension, agentInfo);
  }

  /**
   * 拨打
   */
  public void dial(String addr, String extension, String dialNumber) {
    log.info("拨打api: {}", freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.DIAL.getApiCommand(), dialNumber, dialNumber, extension, dialNumber));
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.DIAL.getApiCommand(), dialNumber, dialNumber, extension, dialNumber));
  }

  /**
   * 转接
   */
  public void transfer(String addr, String id, String dialNumber) {
    // 如果应答了 使用id  没有应答  使用code
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.TRANSFER.getApiCommand(), id, dialNumber));
  }

  /**
   * 保持
   */
  public void hold(String addr, String id) {
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.HOLD.getApiCommand(), id));
  }

  public AgentInfo agent(String addr, String extension) {
    AgentInfo agentInfo = null;
    String result = client.sendSyncApiCommandReturnBody(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.GET_AGENT_INFO.getApiCommand(), extension));
    log.info(result);
    String[] agentsTextArr = result.split("\n");
    if (agentsTextArr.length > 0) {
      List<String> titleList = getContent(agentsTextArr[0]);
      if (CollUtil.isNotEmpty(titleList) && titleList.size() > 5) {
        Map<String, Object> agentInfoMap = new HashMap<>(64);
        List<String> contentList = getContent(agentsTextArr[1]);
        for (int i = 0; i < titleList.size(); i++) {
          agentInfoMap.put(titleList.get(i), contentList.get(i));
        }
        agentInfo = JSON.parseObject(JSON.toJSONString(agentInfoMap), AgentInfo.class);
      }
    }
    log.info(result);
    return agentInfo;
  }

  private List<String> getContent(String fieldText) {
    String[] fields = fieldText.split("\\|");
    return new ArrayList<>(Arrays.asList(fields));
  }

}

