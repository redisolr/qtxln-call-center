package com.qtxln.component.result;

/**
 * ResultCode
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 19:32 下午
 * @since 1.0
 */
public class ResultCode {

  private ResultCode() {
  }

  /**
   * 0000000 一切ok
   */
  public static final String C00000 = "00000";

  /**
   * 参数异常
   */
  public static final String A0400 = "A0400";
  /**
   * 请求方式错误
   */
  public static final String A0405 = "A0405";
  /**
   * 系统错误
   */
  public static final String B0500 = "B0500";
  /**
   * 分机号重复
   */
  public static final String A1001 = "A1001";
  /**
   * 分机不存在
   */
  public static final String A1002 = "A1002";
  /**
   * 分机密码错误
   */
  public static final String A1003 = "A1003";
  /**
   * 分机未注册
   */
  public static final String A1004 = "A1004";
}

