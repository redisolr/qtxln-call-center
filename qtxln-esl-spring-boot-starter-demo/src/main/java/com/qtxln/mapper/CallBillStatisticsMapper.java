package com.qtxln.mapper;

import com.qtxln.model.entity.CallBillStatistics;
import com.qtxln.model.entity.CallDistribution;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 话单统计 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-23
 */
public interface CallBillStatisticsMapper extends BaseMapper<CallBillStatistics> {

  /**
   * 查询当天话单信息
   *
   * @return 话单统计信息
   */
  CallBillStatistics callBillStatisticsOneDay();


  /**
   * 根据日期获取通话分布
   * @param startDate 开始日期
   * @param endDate 结束日期
   * @return 通话数据
   */
  List<CallDistribution> callDistributionByDay(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
