package com.qtxln.service;

import com.qtxln.model.bo.CallCenterExtensionBO;
import com.qtxln.model.entity.CallCenterExtension;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分机表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-31
 */
public interface CallCenterExtensionService extends IService<CallCenterExtension> {

  /**
   * 添加分机
   * @param callCenterExtensionBO 分机信息
   * @return 是否添加成功
   */
  boolean insertCallCenterExtension(CallCenterExtensionBO callCenterExtensionBO);

  /**
   * 更新分机
   * @param callCenterExtensionBO 分机信息
   * @return 是否添加成功
   */
  boolean updateCallCenterExtension(CallCenterExtensionBO callCenterExtensionBO);

  /**
   * 获取分机详情
   * @param id 分机id
   * @return 分机信息
   */
  CallCenterExtensionBO getCallCenterExtension(Long id);

  /**
   * 删除分机
   * @param id 分机id
   * @return 是否删除成功
   */
  boolean deleteCallCenterExtension(Long id);

  /**
   * 分页查询分机列表
   * @param callCenterExtensionBO 分机查询条件
   * @return 分机分页信息
   */
  IPage<CallCenterExtensionBO> listCallCenterExtension(CallCenterExtensionBO callCenterExtensionBO);

  /**
   * 查询全部分机
   * @return 分机列表
   */
  List<CallCenterExtensionBO> queryAll();

}
