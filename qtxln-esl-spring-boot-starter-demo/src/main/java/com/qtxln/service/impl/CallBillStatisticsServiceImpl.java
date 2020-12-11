package com.qtxln.service.impl;

import com.qtxln.mapper.CallBillStatisticsMapper;
import com.qtxln.model.bo.CallBillStatisticsBO;
import com.qtxln.model.bo.CallDistributionBO;
import com.qtxln.model.entity.CallBillStatistics;
import com.qtxln.model.entity.CallDistribution;
import com.qtxln.service.CallBillStatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 话单统计 服务实现类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-23
 */
@Service
public class CallBillStatisticsServiceImpl extends ServiceImpl<CallBillStatisticsMapper, CallBillStatistics> implements CallBillStatisticsService {

  private final CallBillStatisticsMapper callBillStatisticsMapper;

  public CallBillStatisticsServiceImpl(CallBillStatisticsMapper callBillStatisticsMapper) {
    this.callBillStatisticsMapper = callBillStatisticsMapper;
  }

  @Override
  public CallBillStatisticsBO callBillStatisticsOneDay() {
    CallBillStatistics callBillStatistics = callBillStatisticsMapper.callBillStatisticsOneDay();
    CallBillStatisticsBO callBillStatisticsBO = new CallBillStatisticsBO();
    BeanUtils.copyProperties(callBillStatistics, callBillStatisticsBO);
    return callBillStatisticsBO;
  }

  @Override
  public CallDistributionBO callDistributionByDay(String startDate, String endDate) {
    List<CallDistribution> callDistributions = callBillStatisticsMapper.callDistributionByDay(startDate, endDate);
    Map<Integer, Long> callMap = new HashMap<>(32);
    callDistributions.forEach(callDistribution -> callMap.put(Integer.valueOf(callDistribution.getCallTime()), callDistribution.getCallCount()));
    List<Long> callList = new ArrayList<>();
    for (int i = 0; i < 24; i++) {
      callList.add(callMap.getOrDefault(i, 0L));
    }
    CallDistributionBO callDistributionBO = new CallDistributionBO();
    callDistributionBO.setCallCount(callList);
    return callDistributionBO;
  }


}
