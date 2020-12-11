package com.qtxln.esl.inbound.option;

/**
 * ConnectState
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:23 下午
 * @since 1.0
 */
public enum ConnectState {

  /**
   * 初始化状态
   */
  INIT,
  /**
   * 正在连接
   */
  CONNECTING,
  /**
   * 连接失败
   */
  FAILED,
  /**
   * 连接成功
   */
  CONNECTED,
  /**
   * 认证成功
   */
  AUTHED,
  /**
   * 认证失败
   */
  AUTHED_FAILED,
  /**
   * 正在关闭连接
   */
  CLOSING,
  /**
   * 连接已关闭
   */
  CLOSED,
  /**
   * 应用已停止
   */
  SHUTDOWN

}

