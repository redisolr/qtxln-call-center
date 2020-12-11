package com.qtxln.mapper;

import com.qtxln.model.bo.SkillGroupBasicsDataBO;
import com.qtxln.model.entity.SkillGroupBasicsData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 技能组基础数据 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-22
 */
public interface SkillGroupBasicsDataMapper extends BaseMapper<SkillGroupBasicsData> {

  /**
   * 查询当天技能组数据
   *
   * @param page                   分页信息
   * @param skillGroupBasicsDataBO 查询条件
   * @return 分页信息
   */
  IPage<SkillGroupBasicsData> listPageSkillGroupDataOneDay(IPage<SkillGroupBasicsData> page,
                                                           @Param("skillGroupBasicsDataBO") SkillGroupBasicsDataBO skillGroupBasicsDataBO);

}
