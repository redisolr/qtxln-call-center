package com.qtxln.service;

import com.qtxln.model.bo.IvrEntryBO;
import com.qtxln.model.entity.IvrEntry;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
public interface IvrEntryService extends IService<IvrEntry> {

  /**
   * 添加ivr entry
   *
   * @param ivrEntryBO ivrEntry信息
   * @return 是否添加成功
   */
  Long insertIvrEntry(IvrEntryBO ivrEntryBO);

  /**
   * 更新ivr entry
   *
   * @param ivrEntryBO ivrEntry信息
   * @return 是否更新成功
   */
  boolean updateIvrEntry(IvrEntryBO ivrEntryBO);

  /**
   * 获取ivrEntry信息
   *
   * @param id ivrEntry id
   * @return ivrEntry 信息
   */
  IvrEntryBO getIvrEntry(Long id);

  /**
   * 删除ivrEntry信息
   *
   * @param id ivrEntry id
   * @return 是否删除成功
   */
  boolean deleteIvrEntry(Long id);

  /**
   * 查询ivrEntry列表
   *
   * @param ivrEntryBO 查询参数
   * @return 分页信息和数据
   */
  IPage<IvrEntryBO> listIvrEntry(IvrEntryBO ivrEntryBO);

}
