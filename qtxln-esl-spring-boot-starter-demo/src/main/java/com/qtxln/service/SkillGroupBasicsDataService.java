package com.qtxln.service;

import com.qtxln.model.bo.SkillGroupBasicsDataBO;
import com.qtxln.model.entity.SkillGroupBasicsData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 技能组基础数据 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-22
 */
public interface SkillGroupBasicsDataService extends IService<SkillGroupBasicsData> {

  /**
   * 查询当天技能组数据
   *
   * @param skillGroupBasicsDataBO 查询条件
   * @return 分页信息
   */
  IPage<SkillGroupBasicsDataBO> listPageSkillGroupBasicsDataOneDay(SkillGroupBasicsDataBO skillGroupBasicsDataBO);

}
