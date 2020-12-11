package com.qtxln.esl.exception;

/**
 * esl编码异常类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 11:07 上午
 * @since 1.0
 */
public class EslDecoderException extends RuntimeException {

  private static final long serialVersionUID = 593031249707167542L;

  public EslDecoderException(String message) {
    super(message);
  }

}
