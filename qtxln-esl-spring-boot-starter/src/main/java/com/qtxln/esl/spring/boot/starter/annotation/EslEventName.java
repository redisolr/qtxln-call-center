package com.qtxln.esl.spring.boot.starter.annotation;

import java.lang.annotation.*;

/**
 * HeaderParser
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 15:54 下午
 * @since 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EslEventName {

  String[] value();

}

