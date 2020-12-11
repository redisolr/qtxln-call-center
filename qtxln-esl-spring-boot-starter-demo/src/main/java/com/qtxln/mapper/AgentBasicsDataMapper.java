package com.qtxln.mapper;

import com.qtxln.model.bo.AgentBasicsDataBO;
import com.qtxln.model.entity.AgentBasicsData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 坐席数据 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
public interface AgentBasicsDataMapper extends BaseMapper<AgentBasicsData> {

  /**
   * 查询当天坐席数据
   *
   * @param page              分页信息
   * @param agentBasicsDataBO 查询条件
   * @return 分页信息
   */
  IPage<AgentBasicsData> listPageAgentBasicsDataOneDay(IPage<AgentBasicsData> page,
                                                       @Param("AgentBasicsDataBO") AgentBasicsDataBO agentBasicsDataBO);

}
