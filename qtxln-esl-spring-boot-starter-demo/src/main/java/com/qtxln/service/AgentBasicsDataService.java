package com.qtxln.service;

import com.qtxln.model.bo.AgentBasicsDataBO;
import com.qtxln.model.entity.AgentBasicsData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 坐席数据 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
public interface AgentBasicsDataService extends IService<AgentBasicsData> {

  /**
   * 查询当天坐席数据
   *
   * @param agentBasicsDataBO 查询条件
   * @return 分页信息
   */
  IPage<AgentBasicsDataBO> listPageAgentBasicsDataOneDay(AgentBasicsDataBO agentBasicsDataBO);

}
