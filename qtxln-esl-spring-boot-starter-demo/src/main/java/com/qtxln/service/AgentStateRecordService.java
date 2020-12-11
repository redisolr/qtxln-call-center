package com.qtxln.service;

import com.qtxln.model.bo.AgentStateRecordBO;
import com.qtxln.model.entity.AgentStateRecord;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 坐席状态记录表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-21
 */
public interface AgentStateRecordService extends IService<AgentStateRecord> {

  /**
   * 添加坐席状态记录
   * @param agentStateRecord 坐席状态信息
   * @return 是否添加成功
   */
  boolean insertAgentStateRecord(AgentStateRecord agentStateRecord);

  /**
   * 获取坐席状态记录
   * @param agentStateRecordBO 查询条件
   * @return 分页信息
   */
  IPage<AgentStateRecordBO> listAgentStateRecord(AgentStateRecordBO agentStateRecordBO);

}
