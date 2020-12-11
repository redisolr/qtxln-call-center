package com.qtxln.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.qtxln.esl.InboundClient;
import com.qtxln.component.config.FreeSwitchApiTemplate;
import com.qtxln.component.constants.FreeSwitchApiEnum;
import com.qtxln.component.constants.agent.AgentInfoStatusEnum;
import com.qtxln.component.constants.cache.CacheName;
import com.qtxln.component.exception.BaseException;
import com.qtxln.component.result.ResultCode;
import com.qtxln.component.util.cache.EhCacheUtils;
import com.qtxln.model.entity.CallCenterExtension;
import com.qtxln.model.esl.AgentInfo;
import com.qtxln.service.AgentOperationService;
import com.qtxln.service.CallCenterExtensionService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 坐席常用操作 服务实现类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-07 14:50
 * @since 1.0
 */
@Service
@Slf4j
public class AgentOperationServiceImpl implements AgentOperationService {

  private final InboundClient client;
  private final CallCenterExtensionService callCenterExtensionService;
  private final FreeSwitchApiTemplate freeSwitchApiTemplate;

  public AgentOperationServiceImpl(InboundClient inboundClient, CallCenterExtensionService callCenterExtensionService,
                                   FreeSwitchApiTemplate freeSwitchApiTemplate) {
    this.client = inboundClient;
    this.callCenterExtensionService = callCenterExtensionService;
    this.freeSwitchApiTemplate = freeSwitchApiTemplate;
  }

  @Override
  public boolean extensionLogin(String addr, String extensionNumber, String password) {
    LambdaQueryWrapper<CallCenterExtension> wrapper = Wrappers.<CallCenterExtension>lambdaQuery()
        .eq(CallCenterExtension::getExtensionNumber, extensionNumber);
    CallCenterExtension callCenterExtension = callCenterExtensionService.getOne(wrapper);
    if (callCenterExtension == null) {
      throw new BaseException(ResultCode.A1002);
    }
    if (!Objects.equals(callCenterExtension.getPassword(), password)) {
      throw new BaseException(ResultCode.A1003);
    }
    return true;
  }

  @Override
  public boolean extensionLogout(String addr, String agent) {
    AgentInfo agentInfo = agent(addr, agent);
    if (agentInfo == null) {
      throw new BaseException(ResultCode.A1004);
    }
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_LOGGED_OUT.getApiCommand(), agent));
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_IDLE.getApiCommand(), agent));
    return true;
  }

  @Override
  public boolean extensionReady(String addr, String agent) {
    AgentInfo agentInfo = agent(addr, agent);
    if (agentInfo == null) {
      throw new BaseException(ResultCode.A1004);
    }
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_AVAILABLE.getApiCommand(), agent));
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_WAITING.getApiCommand(), agent));
    agentInfo.setAgentStatus(AgentInfoStatusEnum.READY.getName());
    // 更新就绪状态
    EhCacheUtils.put(CacheName.EH_AGENT, agent, agentInfo);
    return true;
  }

  @Override
  public boolean extensionNoReady(String addr, String agent) {
    AgentInfo agentInfo = agent(addr, agent);
    if (agentInfo == null) {
      throw new BaseException(ResultCode.A1004);
    }
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATUS_ON_BREAK.getApiCommand(), agent));
    client.sendSyncApiCommand(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.SET_AGENT_STATE_WAITING.getApiCommand(), agent));
    agentInfo.setAgentStatus(AgentInfoStatusEnum.NOT_READY.getName());
    // 更新就绪状态
    EhCacheUtils.put(CacheName.EH_AGENT, agent, agentInfo);
    return true;
  }

  public AgentInfo agent(String addr, String agent) {
    AgentInfo agentInfo = null;
    String result = client.sendSyncApiCommandReturnBody(addr,
        freeSwitchApiTemplate.getApiCommand(FreeSwitchApiEnum.GET_AGENT_INFO.getApiCommand(), agent));
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
    return agentInfo;
  }

  private List<String> getContent(String fieldText) {
    String[] fields = fieldText.split("\\|");
    return new ArrayList<>(Arrays.asList(fields));
  }

}
