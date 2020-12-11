package com.qtxln.mapper;

import com.qtxln.model.entity.AgentStateRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 坐席状态记录表 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
public interface AgentStateRecordMapper extends BaseMapper<AgentStateRecord> {

  /**
   * 根据坐席id获取坐席最新状态信息
   * @param agentId 坐席id
   * @return 坐席状态信息
   */
  AgentStateRecord getAgentStateRecordLimitOneByAgentId(Long agentId);

}
