package com.qtxln.service;

import com.qtxln.model.bo.CallBillStatisticsBO;
import com.qtxln.model.bo.CallDistributionBO;
import com.qtxln.model.entity.CallBillStatistics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 话单统计 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-23
 */
public interface CallBillStatisticsService extends IService<CallBillStatistics> {

  /**
   * 查询当天话单信息
   *
   * @return 话单统计信息
   */
  CallBillStatisticsBO callBillStatisticsOneDay();

  /**
   * 根据日期获取通话分布
   *
   * @param startDate 开始日期
   * @param endDate   结束日期
   * @return 通话数据
   */
  CallDistributionBO callDistributionByDay(String startDate, String endDate);

}
