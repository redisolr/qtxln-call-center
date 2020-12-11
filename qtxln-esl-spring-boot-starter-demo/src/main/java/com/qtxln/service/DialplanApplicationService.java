package com.qtxln.service;

import com.qtxln.model.bo.DialplanApplicationBO;
import com.qtxln.model.entity.DialplanApplication;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 拨号计划-app表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-06
 */
public interface DialplanApplicationService extends IService<DialplanApplication> {

  /**
   * 添加拨号计划App
   * @param dialplanApplicationBO app信息
   * @return 是否添加成功
   */
  boolean insertDialplanApp(DialplanApplicationBO dialplanApplicationBO);

  /**
   * 更新拨号计划App
   * @param dialplanApplicationBO app信息
   * @return 是否更新成功
   */
  boolean updateDialplanApp(DialplanApplicationBO dialplanApplicationBO);

  /**
   * 获取拨号计划App列表
   * @param dialplanApplicationBO 查询条件
   * @return  分页列表
   */
  IPage<DialplanApplicationBO> listDialplanApp(DialplanApplicationBO dialplanApplicationBO);

  /**
   * 获取拨号计划App详情
   * @param id
   * @return
   */
  DialplanApplicationBO getDialplanApp(Long id);

  /**
   * 删除拨号计划App
   * @param id
   * @return
   */
  boolean deleteDialplanApp(Long id);

}
