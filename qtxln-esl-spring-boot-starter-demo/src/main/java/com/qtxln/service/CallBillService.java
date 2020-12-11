package com.qtxln.service;

import com.qtxln.model.bo.CallBillBO;
import com.qtxln.model.bo.CallBillInfoBO;
import com.qtxln.model.entity.CallBill;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 通话清单(话单) 服务类
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-21
 */
public interface CallBillService extends IService<CallBill> {

  /**
   * 根据通话uuid更新数据
   *
   * @param callBill 话单信息
   * @return 是否更新成功
   */
  boolean updateByUniqueId(CallBill callBill);

  /**
   * 根据memberSessionId 查询通话条数
   *
   * @param memberSessionId sessionId
   * @return 数据条数
   */
  int countByMemberSessionId(String memberSessionId);

  /**
   * 根据memberSessionId 查询通话记录
   * @param memberSessionId sessionId
   * @return 通话记录
   */
  List<CallBill> getByMemberSessionId(String memberSessionId);

  /**
   * 获取话单列表
   *
   * @param callBillBO 查询条件
   * @return 分页信息
   */
  IPage<CallBillBO> listCallBill(CallBillBO callBillBO);

  /**
   * 获取话单详情
   *
   * @param id 话单id
   * @return 事件列表
   */
  List<CallBillInfoBO> getCallBill(Long id);

}
