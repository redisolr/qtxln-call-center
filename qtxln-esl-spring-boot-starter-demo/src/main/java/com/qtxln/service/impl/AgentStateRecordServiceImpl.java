package com.qtxln.service.impl;

import com.qtxln.component.util.DateUtils;
import com.qtxln.mapper.AgentStateRecordMapper;
import com.qtxln.model.bo.AgentStateRecordBO;
import com.qtxln.model.entity.AgentStateRecord;
import com.qtxln.service.AgentStateRecordService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 坐席状态记录表 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@Service
public class AgentStateRecordServiceImpl extends ServiceImpl<AgentStateRecordMapper, AgentStateRecord> implements AgentStateRecordService {

  private final AgentStateRecordMapper agentStateRecordMapper;

  public AgentStateRecordServiceImpl(AgentStateRecordMapper agentStateRecordMapper) {
    this.agentStateRecordMapper = agentStateRecordMapper;
  }

  @Override
  public boolean insertAgentStateRecord(AgentStateRecord agentStateRecord) {
    AgentStateRecord stateRecordOld = agentStateRecordMapper.getAgentStateRecordLimitOneByAgentId(agentStateRecord.getAgentId());
    if (stateRecordOld == null) {
      agentStateRecord.setDuration(0L);
      return save(agentStateRecord);
    }
    if (Objects.equals(stateRecordOld.getAgentState(), agentStateRecord.getAgentState())) {
      return false;
    }
    long second = DateUtils.betweenSecond(stateRecordOld.getCreateTime(), LocalDateTime.now());
    stateRecordOld.setDuration(second);
    updateById(stateRecordOld);
    return save(agentStateRecord);
  }

  @Override
  public IPage<AgentStateRecordBO> listAgentStateRecord(AgentStateRecordBO agentStateRecordBO) {
    IPage<AgentStateRecord> page = new Page<>(agentStateRecordBO.getPageNum(), agentStateRecordBO.getPageSize());
    LambdaQueryWrapper<AgentStateRecord> wrapper = Wrappers.<AgentStateRecord>lambdaQuery().eq(AgentStateRecord::getAgentId, agentStateRecordBO.getAgentId());
    wrapper.orderByDesc(AgentStateRecord::getCreateTime);
    IPage<AgentStateRecord> agentStateRecordPage = agentStateRecordMapper.selectPage(page, wrapper);
    IPage<AgentStateRecordBO> pageAgentStateRecord = new Page<>();
    List<AgentStateRecordBO> callCenterMediaBOList = JSON.parseObject(JSON.toJSONString(agentStateRecordPage.getRecords()), new TypeReference<List<AgentStateRecordBO>>() {
    });
    pageAgentStateRecord.setCurrent(agentStateRecordPage.getCurrent());
    pageAgentStateRecord.setSize(agentStateRecordPage.getSize());
    pageAgentStateRecord.setRecords(callCenterMediaBOList);
    pageAgentStateRecord.setTotal(agentStateRecordPage.getTotal());
    return pageAgentStateRecord;
  }
}
