package com.qtxln.service;

import com.qtxln.model.bo.DialplanBO;
import com.qtxln.model.entity.Dialplan;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 拨号计划表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-08
 */
public interface DialplanService extends IService<Dialplan> {

  /**
   * 添加拨号计划
   * @param dialplanBO 拨号计划信息
   * @return 是否添加成功
   */
  boolean insertDialplan(DialplanBO dialplanBO);

  /**
   * 更新拨号计划
   * @param dialplanBO 拨号计划信息
   * @return 是否更新成功
   */
  boolean updateDialplan(DialplanBO dialplanBO);

  /**
   * 获取拨号计划详情
   * @param id 拨号计划id
   * @return 拨号计划详情
   */
  DialplanBO getDialplan(Long id);

  /**
   * 删除拨号计划
   * @param id 拨号计划id
   * @return 是否删除成功
   */
  boolean deleteDialplan(Long id);

  /**
   * 获取拨号计划列表
   * @param dialplanBO 查询条件
   * @return 分页信息
   */
  IPage<DialplanBO> listDialplan(DialplanBO dialplanBO);

}
