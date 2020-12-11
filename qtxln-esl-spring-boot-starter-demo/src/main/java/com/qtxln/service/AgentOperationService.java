package com.qtxln.service;

/**
 * 坐席常用操作service
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-07 14:50
 * @since 1.0
 */
public interface AgentOperationService {

  /**
   * 分机(坐席)登录接口
   * @param addr 地址
   * @param extensionNumber 分机号
   * @param password 密码
   * @return 是否登录成功
   */
  boolean extensionLogin(String addr, String extensionNumber, String password);

  /**
   * 分机(坐席)退出登录
   * @param addr 地址
   * @param extensionNumber 分机号
   * @return 是否退出成功
   */
  boolean extensionLogout(String addr, String extensionNumber);

  /**
   * 就绪
   * @param addr 地址
   * @param extensionNumber 分机号
   * @return 是否就绪成功
   */
  boolean extensionReady(String addr, String extensionNumber);

  /**
   * 未就绪
   * @param addr 地址
   * @param extensionNumber 分机号
   * @return 是否未就绪成功
   */
  boolean extensionNoReady(String addr, String extensionNumber);

}
