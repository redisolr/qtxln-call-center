package com.qtxln.component.exception;


import com.qtxln.component.result.InvokerResult;
import com.qtxln.component.result.ResultExt;
import com.qtxln.component.util.ResponsePropsUtils;

/**
 * ResultException
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 19:53 下午
 * @since 1.0
 */
public interface ResultException {

  /**
   * 获取错误输出
   * @return InvokerResult
   */
  default <T> InvokerResult<T> getResponse() {
    return ResultExt.fail(getCode(), ResponsePropsUtils.getByKey(getCode(), "未知异常"));
  }

  /**
   * 获取code
   * @return 状态码
   */
  String getCode();
}

