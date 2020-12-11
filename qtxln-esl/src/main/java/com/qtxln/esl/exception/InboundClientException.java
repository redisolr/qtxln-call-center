package com.qtxln.esl.exception;

/**
 * 内连客户端异常类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 11:19 上午
 * @since 1.0
 */
public class InboundClientException extends RuntimeException {

  private static final long serialVersionUID = 8104636028990100885L;

  public InboundClientException(String message) {
    super(message);
  }

  public InboundClientException(String message, Throwable cause) {
    super(message, cause);
  }

  public InboundClientException(Throwable cause) {
    super(cause);
  }

}
