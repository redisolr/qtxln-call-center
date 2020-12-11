package com.qtxln;

import com.aegis.fs.component.exception.BaseException;
import com.aegis.fs.component.result.InvokerResult;
import com.aegis.fs.component.result.ResultCode;
import com.aegis.fs.component.result.ResultExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局异常处理
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 14:11 下午
 * @since 1.0
 */
@Slf4j
@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  protected InvokerResult<Object> handleException(HttpServletRequest request, Exception ex) {
    // 业务异常
    if (ex instanceof BaseException) {
      BaseException bs = (BaseException) ex;
      return bs.getResponse();
    }
    // 请求参数异常
    if (ex instanceof BindException) {
      StringBuilder sb = new StringBuilder();
      BindingResult bindingResult = ((BindException) ex).getBindingResult();
      if (bindingResult.hasErrors()) {
        List<ObjectError> errorList = bindingResult.getAllErrors();
        errorList.forEach(error -> {
          FieldError fieldError = (FieldError) error;
          sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";");
        });
      }
      log.warn(sb.toString(), ex);
      return ResultExt.fail(ResultCode.A0400, sb.toString());
    }
    // 非法参数异常
    if (ex instanceof IllegalArgumentException) {
      log.error("参数异常", ex);
      return ResultExt.fail(ResultCode.A0400);
    }
    // 请求方法异常
    if (ex instanceof HttpRequestMethodNotSupportedException) {
      log.warn("Request method 异常", ex);
      return ResultExt.fail(ResultCode.A0405);
    }
    // 其他异常
    String desc = String.format("系统异常,地址:%s", request.getRequestURI());
    log.error(desc, ex);
    return ResultExt.fail(ResultCode.B0500);
  }

}

