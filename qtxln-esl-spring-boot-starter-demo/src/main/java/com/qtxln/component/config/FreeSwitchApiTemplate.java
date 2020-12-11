package com.qtxln.component.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * fs命令处理模板
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/05/19 09:19 上午
 * @since 1.0
 */
@Component
public class FreeSwitchApiTemplate {

  private final MessageSource messageSource;

  @Autowired
  public FreeSwitchApiTemplate(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  public String getApiCommand(String key, Object... args) {
    return this.messageSource.getMessage(key, args, Locale.getDefault());
  }

}

