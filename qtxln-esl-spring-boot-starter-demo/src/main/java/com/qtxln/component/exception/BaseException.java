package com.qtxln.component.exception;

import lombok.Getter;

/**
 * 基础异常类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 18:59 下午
 * @since 1.0
 */
public class BaseException extends RuntimeException implements ResultException{

  private static final long serialVersionUID = 2422906733222055773L;

  @Getter
  protected final String code;

  public BaseException(String code) {
    super();
    this.code = code;
  }

  @Override
  public String getCode() {
    return this.code;
  }
}

