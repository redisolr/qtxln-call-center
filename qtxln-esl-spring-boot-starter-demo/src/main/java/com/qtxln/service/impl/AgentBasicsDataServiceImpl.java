package com.qtxln.service.impl;

import com.qtxln.component.constants.agent.AgentInfoEnum;
import com.qtxln.component.constants.agent.AgentInfoStatusEnum;
import com.qtxln.mapper.AgentBasicsDataMapper;
import com.qtxln.model.bo.AgentBasicsDataBO;
import com.qtxln.model.entity.AgentBasicsData;
import com.qtxln.model.esl.AgentInfo;
import com.qtxln.service.AgentBasicsDataService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Table;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 坐席数据 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
@Service
public class AgentBasicsDataServiceImpl extends ServiceImpl<AgentBasicsDataMapper, AgentBasicsData> implements AgentBasicsDataService {

  private final AgentBasicsDataMapper agentBasicsDataMapper;

  public AgentBasicsDataServiceImpl(AgentBasicsDataMapper agentBasicsDataMapper) {
    this.agentBasicsDataMapper = agentBasicsDataMapper;
  }

  @Override
  public IPage<AgentBasicsDataBO> listPageAgentBasicsDataOneDay(AgentBasicsDataBO agentBasicsDataBO) {
    IPage<AgentBasicsData> page = new Page<>(agentBasicsDataBO.getPageNum(), agentBasicsDataBO.getPageSize());
    IPage<AgentBasicsData> agentBasicsDataPage = agentBasicsDataMapper.listPageAgentBasicsDataOneDay(page, agentBasicsDataBO);
    IPage<AgentBasicsDataBO> basicsDataPage = new Page<>();
    List<AgentBasicsDataBO> skillGroupList = JSON.parseObject(JSON.toJSONString(agentBasicsDataPage.getRecords()), new TypeReference<List<AgentBasicsDataBO>>() {
    });
    Table<String, String, AgentInfo> agentInfoTable = AgentInfoEnum.INSTANCE.getInstance();
    skillGroupList.forEach(agentBasics -> {
      AgentInfo agentInfo = agentInfoTable.get(agentBasics.getSkillGroupName(), agentBasics.getAgentName());
      if (agentInfo == null) {
        agentBasics.setAgentState(AgentInfoStatusEnum.NOT_LOGIN.getName());
      } else {
        agentBasics.setAgentState(agentInfo.getAgentStatus());
      }
      // 总登录时长
      agentBasics.setTotalLoggedInTime(agentBasics.getTotalBreakTime() + agentBasics.getTotalReadyTime()
          + agentBasics.getTotalRingTime() + agentBasics.getTotalTalkTime());
      // 平均就绪时长
      agentBasics.setAverageReadyTime(BigDecimal.ZERO);
      if (agentBasics.getReadyCount() != null && agentBasics.getReadyCount() != 0) {
        BigDecimal divide = BigDecimal.valueOf(agentBasics.getTotalReadyTime())
            .divide(new BigDecimal(agentBasics.getReadyCount()), 2, BigDecimal.ROUND_HALF_UP);
        agentBasics.setAverageReadyTime(divide);
      }
      // 平均振铃时长
      agentBasics.setAverageRingTime(BigDecimal.ZERO);
      if (agentBasics.getRingCount() != null && agentBasics.getRingCount() != 0) {
        BigDecimal divide = BigDecimal.valueOf(agentBasics.getTotalRingTime())
            .divide(new BigDecimal(agentBasics.getRingCount()), 2, BigDecimal.ROUND_HALF_UP);
        agentBasics.setAverageRingTime(divide);
      }
      // 平均通话时长
      agentBasics.setAverageTalkTime(BigDecimal.ZERO);
      if (agentBasics.getTotalCalls() != null && agentBasics.getTotalCalls() != 0) {
        BigDecimal divide = BigDecimal.valueOf(agentBasics.getTotalTalkTime())
            .divide(new BigDecimal(agentBasics.getTotalCalls()), 2, BigDecimal.ROUND_HALF_UP);
        agentBasics.setAverageTalkTime(divide);
      }
    });
    basicsDataPage.setCurrent(agentBasicsDataPage.getCurrent());
    basicsDataPage.setSize(agentBasicsDataPage.getSize());
    basicsDataPage.setRecords(skillGroupList);
    basicsDataPage.setTotal(agentBasicsDataPage.getTotal());
    return basicsDataPage;
  }
}
