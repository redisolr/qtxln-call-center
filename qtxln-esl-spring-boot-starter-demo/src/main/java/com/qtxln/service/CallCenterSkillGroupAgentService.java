package com.qtxln.service;

import com.qtxln.model.bo.CallCenterSkillGroupAgentBO;
import com.qtxln.model.entity.CallCenterSkillGroupAgent;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 技能组坐席表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-03
 */
public interface CallCenterSkillGroupAgentService extends IService<CallCenterSkillGroupAgent> {

  /**
   * 添加技能组坐席
   *
   * @param callCenterSkillGroupAgentBO 坐席信息
   * @return 是否添加成功
   */
  boolean insertCallCenterSkillGroupAgent(CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO);

  /**
   * 更新技能组坐席
   *
   * @param callCenterSkillGroupAgentBO 坐席信息
   * @return 是否添加成功
   */
  boolean updateCallCenterSkillGroupAgent(CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO);

  /**
   * 获取技能组坐席列表
   *
   * @param callCenterSkillGroupAgentBO 查询条件
   * @return 分页信息
   */
  IPage<CallCenterSkillGroupAgentBO> listCallCenterSkillGroupAgent(CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO);

  /**
   * 获取技能组坐席信息
   *
   * @param id 坐席id
   * @return 技能组坐席信息
   */
  CallCenterSkillGroupAgentBO getCallCenterSkillGroupAgent(Long id);

  /**
   * 删除技能组坐席信息
   *
   * @param id 坐席id
   * @return 是否删除成功
   */
  boolean deleteCallCenterSkillGroupAgent(Long id);

  /**
   * 根据坐席名获取技能组名称
   *
   * @param agentName 坐席名称
   * @return 技能组名称
   */
  CallCenterSkillGroupAgent getSkillGroupNameByAgent(String agentName);

}
