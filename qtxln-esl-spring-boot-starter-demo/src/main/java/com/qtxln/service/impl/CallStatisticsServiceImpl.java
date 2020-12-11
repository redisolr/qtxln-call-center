package com.qtxln.service.impl;

import com.qtxln.mapper.CallStatisticsMapper;
import com.qtxln.model.bo.AgentInfoStatisticsBO;
import com.qtxln.model.entity.statistics.CallGiveUp;
import com.qtxln.model.entity.statistics.CallTime;
import com.qtxln.model.entity.statistics.InBoundCount;
import com.qtxln.model.entity.statistics.OutBoundCount;
import com.qtxln.service.CallStatisticsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 通话统计Service实现类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/1 9:10 上午
 * @since 1.0
 */
@Service
public class CallStatisticsServiceImpl implements CallStatisticsService {

  private final CallStatisticsMapper callStatisticsMapper;

  @Autowired
  public CallStatisticsServiceImpl(CallStatisticsMapper callStatisticsMapper) {
    this.callStatisticsMapper = callStatisticsMapper;
  }

  @Override
  public AgentInfoStatisticsBO getAgentInfo(String agent) {
    // 呼入总量
    InBoundCount inBoundCount = callStatisticsMapper.countInBoundByAgent(agent);
    // 呼出总量
    OutBoundCount outBoundCount = callStatisticsMapper.countOutBoundByAgent(agent);
    // 通话时间
    CallTime callTime = callStatisticsMapper.countCallTime(agent);
    AgentInfoStatisticsBO agentInfoStatisticsBO = new AgentInfoStatisticsBO();
    agentInfoStatisticsBO.setInBoundCount(inBoundCount.getInBoundTotal());
    agentInfoStatisticsBO.setInBoundConnectedTotal(inBoundCount.getConnectedTotal());
    agentInfoStatisticsBO.setInBoundNotConnectedTotal(inBoundCount.getNotConnectedTotal());
    agentInfoStatisticsBO.setOutBoundCount(outBoundCount.getOutBoundTotal());
    agentInfoStatisticsBO.setOutBoundConnectedTotal(outBoundCount.getConnectedTotal());
    agentInfoStatisticsBO.setOutBoundNotConnectedTotal(outBoundCount.getNotConnectedTotal());
    long totalCall = inBoundCount.getInBoundTotal() + outBoundCount.getOutBoundTotal();
    agentInfoStatisticsBO.setTotalCount(totalCall);
    if (callTime != null) {
      agentInfoStatisticsBO.setTotalTime(callTime.getTotalTime());
      agentInfoStatisticsBO.setTalkTime(callTime.getTalkTime());
      long ringTime = callTime.getTotalTime() - callTime.getTalkTime();
      agentInfoStatisticsBO.setRingTime(ringTime);
      BigDecimal total = BigDecimal.valueOf(totalCall);
      agentInfoStatisticsBO.setAverageRingTime(BigDecimal.valueOf(ringTime).divideToIntegralValue(total));
      agentInfoStatisticsBO.setAverageTalkTime(BigDecimal.valueOf(callTime.getTalkTime()).divideToIntegralValue(total));
    } else {
      agentInfoStatisticsBO.setTotalTime(0L);
      agentInfoStatisticsBO.setTalkTime(0L);
      agentInfoStatisticsBO.setRingTime(0L);
      agentInfoStatisticsBO.setAverageRingTime(BigDecimal.ZERO);
      agentInfoStatisticsBO.setAverageTalkTime(BigDecimal.ZERO);
    }
    CallGiveUp callGiveUp = callStatisticsMapper.countCallGiveUp(agent, "3000");
    BeanUtils.copyProperties(callGiveUp, agentInfoStatisticsBO);
    return agentInfoStatisticsBO;
  }


}
