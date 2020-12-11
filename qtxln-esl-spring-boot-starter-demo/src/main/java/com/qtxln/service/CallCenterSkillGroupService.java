package com.qtxln.service;

import com.qtxln.model.bo.CallCenterSkillGroupBO;
import com.qtxln.model.entity.CallCenterSkillGroup;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 技能组表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-02
 */
public interface CallCenterSkillGroupService extends IService<CallCenterSkillGroup> {

  /**
   * 添加技能组
   *
   * @param callCenterSkillGroupBO 技能组信息
   * @return 是否添加成功
   */
  boolean insertCallCenterSkillGroup(CallCenterSkillGroupBO callCenterSkillGroupBO);

  /**
   * 更新技能组
   *
   * @param callCenterSkillGroupBO 技能组信息
   * @return 是否添加成功
   */
  boolean updateCallCenterSkillGroup(CallCenterSkillGroupBO callCenterSkillGroupBO);

  /**
   * 获取技能组列表
   *
   * @param callCenterSkillGroupBO 查询条件
   * @return 分页信息
   */
  IPage<CallCenterSkillGroupBO> listCallCenterSkillGroup(CallCenterSkillGroupBO callCenterSkillGroupBO);

  /**
   * 获取技能组详情
   *
   * @param id 技能组id
   * @return 技能组信息
   */
  CallCenterSkillGroupBO getCallCenterSkillGroup(Long id);

  /**
   * 删除技能组
   *
   * @param id 技能组id
   * @return 是否删除成功
   */
  boolean deleteCallCenterSkillGroup(Long id);

  /**
   * 查询全部技能组
   * @return 技能组列表
   */
  List<CallCenterSkillGroupBO> queryAll();

}
