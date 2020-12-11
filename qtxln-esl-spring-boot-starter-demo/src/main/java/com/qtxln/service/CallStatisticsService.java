package com.qtxln.service;

import com.qtxln.model.bo.AgentInfoStatisticsBO;

/**
 * 通话统计Service
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/31 18:17 下午
 * @since 1.0
 */
public interface CallStatisticsService {

  /**
   * 获取坐席通话信息
   * @param agent 坐席
   * @return 坐席通话信息
   */
  AgentInfoStatisticsBO getAgentInfo(String agent);

}
