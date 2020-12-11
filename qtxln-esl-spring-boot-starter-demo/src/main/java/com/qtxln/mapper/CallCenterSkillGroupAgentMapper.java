package com.qtxln.mapper;

import com.qtxln.model.bo.CallCenterSkillGroupAgentBO;
import com.qtxln.model.entity.CallCenterSkillGroupAgent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 技能组坐席表 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-03
 */
public interface CallCenterSkillGroupAgentMapper extends BaseMapper<CallCenterSkillGroupAgent> {

  /**
   * 分页查询技能组坐席信息
   *
   * @param page                        分页信息
   * @param callCenterSkillGroupAgentBO 查询条件
   * @return 分页信息
   */
  IPage<CallCenterSkillGroupAgent> listPageSkillGroupAgent(IPage<CallCenterSkillGroupAgent> page,
                                                           @Param("callCenterSkillGroupAgentBO") CallCenterSkillGroupAgentBO callCenterSkillGroupAgentBO);

  /**
   * 根据坐席名获取技能组名称
   *
   * @param agentName 坐席名称
   * @return 技能组名称
   */
  CallCenterSkillGroupAgent getSkillGroupNameByAgent(String agentName);

}
