package com.qtxln.service.impl;

import com.qtxln.mapper.CallCenterSkillGroupAgentMapper;
import com.qtxln.model.bo.CallCenterSkillGroupAgentBO;
import com.qtxln.model.entity.CallCenterSkillGroupAgent;
import com.qtxln.service.CallCenterSkillGroupAgentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 技能组坐席表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-03
 */
@Service
public class CallCenterSkillGroupAgentServiceImpl extends ServiceImpl<CallCenterSkillGroupAgentMapper, CallCenterSkillGroupAgent> implements CallCenterSkillGroupAgentService {

  private final CallCenterSkillGroupAgentMapper callCenterSkillGroupAgentMapper;

  @Autowired
  public CallCenterSkillGroupAgentServiceImpl(CallCenterSkillGroupAgentMapper callCenterSkillGroupAgentMapper) {
    this.callCenterSkillGroupAgentMapper = callCenterSkillGroupAgentMapper;
  }

  @Override
  public boolean insertCallCenterSkillGroupAgent(CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO) {
    CallCenterSkillGroupAgent callCenterSkillGroupAgent = new CallCenterSkillGroupAgent();
    BeanUtils.copyProperties(callCenterSkillGroupAgentBO, callCenterSkillGroupAgent);
    return save(callCenterSkillGroupAgent);
  }

  @Override
  public boolean updateCallCenterSkillGroupAgent(CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO) {
    CallCenterSkillGroupAgent callCenterSkillGroupAgent = new CallCenterSkillGroupAgent();
    BeanUtils.copyProperties(callCenterSkillGroupAgentBO, callCenterSkillGroupAgent);
    return updateById(callCenterSkillGroupAgent);
  }

  @Override
  public IPage<CallCenterSkillGroupAgentBO> listCallCenterSkillGroupAgent(CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO) {
    IPage<CallCenterSkillGroupAgent> page = new Page<>(callCenterSkillGroupAgentBO.getPageNum(), callCenterSkillGroupAgentBO.getPageSize());
    IPage<CallCenterSkillGroupAgent> skillGroupAgentPage = callCenterSkillGroupAgentMapper.listPageSkillGroupAgent(page, callCenterSkillGroupAgentBO);
    IPage<CallCenterSkillGroupAgentBO> pageSkillGroupAgentBO = new Page<>();
    List<CallCenterSkillGroupAgentBO> skillGroupList = JSON.parseObject(JSON.toJSONString(skillGroupAgentPage.getRecords()), new TypeReference<List<CallCenterSkillGroupAgentBO>>() {
    });
    pageSkillGroupAgentBO.setCurrent(skillGroupAgentPage.getCurrent());
    pageSkillGroupAgentBO.setSize(skillGroupAgentPage.getSize());
    pageSkillGroupAgentBO.setRecords(skillGroupList);
    pageSkillGroupAgentBO.setTotal(skillGroupAgentPage.getTotal());
    return pageSkillGroupAgentBO;
  }

  @Override
  public CallCenterSkillGroupAgentBO getCallCenterSkillGroupAgent(Long id) {
    CallCenterSkillGroupAgent callCenterSkillGroupAgent = getById(id);
    CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO = new CallCenterSkillGroupAgentBO();
    BeanUtils.copyProperties(callCenterSkillGroupAgent, callCenterSkillGroupAgentBO);
    return callCenterSkillGroupAgentBO;
  }

  @Override
  public boolean deleteCallCenterSkillGroupAgent(Long id) {
    return removeById(id);
  }

  @Override
  @Cacheable(value = "eh-skill-group-name", key = "#agentName")
  public CallCenterSkillGroupAgent getSkillGroupNameByAgent(String agentName) {
    return callCenterSkillGroupAgentMapper.getSkillGroupNameByAgent(agentName);
  }


}
