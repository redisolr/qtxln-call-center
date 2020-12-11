package com.qtxln.mapper;

import com.qtxln.model.entity.statistics.CallGiveUp;
import com.qtxln.model.entity.statistics.CallTime;
import com.qtxln.model.entity.statistics.InBoundCount;
import com.qtxln.model.entity.statistics.OutBoundCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 通话统计Mapper
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/31 17:58 下午
 * @since 1.0
 */
@Mapper
@Repository
public interface CallStatisticsMapper {

  /**
   * 根据坐席统计呼入信息
   * @param agent 坐席
   * @return 呼入信息
   */
  InBoundCount countInBoundByAgent(String agent);

  /**
   * 根据坐席统计呼出信息
   * @param agent 坐席
   * @return 呼出信息
   */
  OutBoundCount countOutBoundByAgent(String agent);

  /**
   * 统计坐席信息
   * @param agent 坐席
   * @return 通话时间统计
   */
  CallTime countCallTime(String agent);

  /**
   * 统计放弃数据
   * @param agent 坐席
   * @param skillGroup 技能组
   * @return 放弃数据
   */
  CallGiveUp countCallGiveUp(@Param("agent") String agent, @Param("skillGroup") String skillGroup);

}
