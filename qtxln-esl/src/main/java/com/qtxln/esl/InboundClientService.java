package com.qtxln.esl;

/**
 * InboundClientService
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:46 下午
 * @since 1.0
 */
public interface InboundClientService {

  /**
   * 内联客户端服务启动
   */
  void start();

  /**
   * 内联客户端服务停止
   */
  void shutdown();

}

