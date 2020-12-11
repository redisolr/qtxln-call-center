package com.qtxln.component.result;

import com.aegis.fs.component.util.ResponsePropsUtils;

import javax.validation.constraints.NotNull;

/**
 * 分页结果
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 19:23 下午
 * @since 1.0
 */
public class InvokerPageResult<T> extends InvokerResult<PagerResultData<T>> {

  private InvokerPageResult(@NotNull T data, Pager pager, String code, String msg) {
    super();
    this.data = new PagerResultData<>(data, pager);
    this.code = code;
    this.msg = msg;
  }

  public InvokerPageResult(@NotNull T data, Pager pager) {
    this(data, pager, ResultCode.C00000, ResponsePropsUtils.getByKey(ResultCode.C00000));
  }

}

