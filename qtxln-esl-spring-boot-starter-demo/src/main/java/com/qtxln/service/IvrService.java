package com.qtxln.service;

import com.qtxln.model.bo.IvrBO;
import com.qtxln.model.entity.Ivr;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * IVR 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
public interface IvrService extends IService<Ivr> {

  /**
   * 添加ivr
   *
   * @param ivrBO ivr信息
   * @return 主键
   */
  Long insertIvr(IvrBO ivrBO);

  /**
   * 更新ivr
   *
   * @param ivrBO ivr信息
   * @return 是否更新成功
   */
  boolean updateIvr(IvrBO ivrBO);

  /**
   * 获取ivr信息
   *
   * @param id ivr id
   * @return ivr 信息
   */
  IvrBO getIvr(Long id);

  /**
   * 删除ivr信息
   *
   * @param id ivr id
   * @return 是否删除成功
   */
  boolean deleteIvr(Long id);

  /**
   * 查询ivr列表
   *
   * @param ivrBO 查询参数
   * @return 分页信息和数据
   */
  IPage<IvrBO> listIvr(IvrBO ivrBO);

}
