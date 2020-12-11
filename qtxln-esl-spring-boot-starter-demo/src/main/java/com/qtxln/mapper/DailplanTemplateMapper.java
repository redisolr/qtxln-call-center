package com.qtxln.mapper;

import com.qtxln.model.bo.DialplanTemplateBO;
import com.qtxln.model.entity.DialplanTemplate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 拨号计划-模板表 Mapper 接口
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-07
 */
public interface DailplanTemplateMapper extends BaseMapper<DialplanTemplate> {

  /**
   * 分页查询模板信息
   * @param page 分页信息
   * @param dialplanTemplateBO 查询条件
   * @return 分页信息
   */
  IPage<DialplanTemplate> listPageDailplanTemplate(IPage<DialplanTemplate> page,
                                                   @Param("dialplanTemplateBO") DialplanTemplateBO dialplanTemplateBO);

}
