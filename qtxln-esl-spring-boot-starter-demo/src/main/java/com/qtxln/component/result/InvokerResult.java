package com.qtxln.component.result;

import com.qtxln.component.util.ResponsePropsUtils;
import lombok.Data;

/**
 * 基础异常类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 18:59 下午
 * @since 1.0
 */
@Data
public class InvokerResult<T> {
  /**
   * 接口返回状态码
   */
  protected String code;
  /**
   * 接口返回数据
   */
  protected T data;
  /**
   * 接口返回信息
   */
  protected String msg;

  public InvokerResult(String code, T data, String msg) {
    this.code = code;
    this.data = data;
    this.msg = msg;
  }

  public InvokerResult(T data) {
    this(ResultCode.C00000, data, ResponsePropsUtils.getByKey(ResultCode.C00000));
  }

  public InvokerResult(String code, String msg) {
    this(code, null, msg);
  }

  public InvokerResult() {
    this(null);
  }
}

