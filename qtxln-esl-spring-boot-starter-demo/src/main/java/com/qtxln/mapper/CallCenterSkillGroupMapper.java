package com.qtxln.mapper;

import com.qtxln.model.bo.CallCenterSkillGroupBO;
import com.qtxln.model.entity.CallCenterSkillGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 技能组表 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-02
 */
public interface CallCenterSkillGroupMapper extends BaseMapper<CallCenterSkillGroup> {

  /**
   * 分页查询技能组信息
   * @param page 分页信息
   * @param callCenterSkillGroupBO 查询条件
   * @return 分页信息
   */
  IPage<CallCenterSkillGroup> listPageSkillGroup(IPage<CallCenterSkillGroup> page,
                                                           @Param("callCenterSkillGroupBO") CallCenterSkillGroupBO callCenterSkillGroupBO);

  /**
   * 查询全部技能组
   * @return 技能组列表
   */
  List<CallCenterSkillGroup> queryAll();

}
