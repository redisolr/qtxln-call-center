package com.qtxln.service;

import com.qtxln.model.bo.DialplanTemplateBO;
import com.qtxln.model.entity.DialplanTemplate;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 拨号计划-模板表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-07
 */
public interface DialplanTemplateService extends IService<DialplanTemplate> {

  /**
   * 添加拨号计划模板
   * @param dialplanTemplateBO 模板信息
   * @return 是否添加成功
   */
  boolean insertDailplanTemplate(DialplanTemplateBO dialplanTemplateBO);

  /**
   * 更新拨号计划模板
   * @param dialplanTemplateBO 模板信息
   * @return 是否更新成功
   */
  boolean updateDailplanTemplate(DialplanTemplateBO dialplanTemplateBO);

  /**
   * 查询模板列表
   * @param dialplanTemplateBO 查询条件
   * @return 列表数据
   */
  IPage<DialplanTemplateBO> listDailplanTemplate(DialplanTemplateBO dialplanTemplateBO);

  /**
   * 获取模板详情
   * @param id 模板id
   * @return 欧模板详情
   */
  DialplanTemplateBO getDailplanTemplate(Long id);

  /**
   * 删除模板数据
   * @param id 模板id
   * @return 是否删除成功
   */
  boolean deleteDailplanTemplate(Long id);

}
