package com.qtxln.component.result;

import com.qtxln.component.util.ResponsePropsUtils;


/**
 * 结果扩展
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 19:45 下午
 * @since 1.0
 */
public class ResultExt {

  private ResultExt() {
  }

  public static <T> InvokerResult<T> fail(String code, String msg) {
    return new InvokerResult<>(code, msg);
  }

  public static <T> InvokerResult<T> fail(String code) {
    return fail(code, ResponsePropsUtils.getByKey(code));
  }

  public static <T> InvokerResult<T> success() {
    return new InvokerResult<>();
  }

  public static <T> InvokerResult<T> successWithData(T data) {
    return new InvokerResult<>(data);
  }

  public static <T> InvokerPageResult<T> successWithPageData(T data, Pager pager) {
    return new InvokerPageResult<>(data, pager);
  }


}

