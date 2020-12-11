package com.qtxln.service;

import com.qtxln.model.bo.CallCenterMediaBO;
import com.qtxln.model.entity.CallCenterMedia;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 呼叫中心-媒体资源表 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-30
 */
public interface CallCenterMediaService extends IService<CallCenterMedia> {

  /**
   * 添加媒体
   * @param callCenterMediaBO 媒体信息
   * @return 是否成功
   */
  boolean insertCallCenterMedia(CallCenterMediaBO callCenterMediaBO);

  /**
   * 更新媒体信息
   * @param callCenterMediaBO 媒体信息
   * @return 是否成功
   */
  boolean updateCallCenterMedia(CallCenterMediaBO callCenterMediaBO);

  /**
   * 获取媒体信息列表
   * @param callCenterMediaBO 媒体信息查询条件
   * @return 分页数据
   */
  IPage<CallCenterMediaBO> listCallCenterMedia(CallCenterMediaBO callCenterMediaBO);

  /**
   * 获取媒体信息详情
   * @param id 媒体信息id
   * @return 媒体信息
   */
  CallCenterMediaBO getCallCenterMedia(Long id);

  /**
   * 删除媒体信息
   * @param id 媒体信息id
   * @return 是否成功
   */
  boolean deleteCallCenterMedia(Long id);

}
