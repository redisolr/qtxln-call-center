package com.qtxln.component.constants;

import lombok.Getter;
import lombok.Setter;

/**
 * 命令枚举
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/13 9:25 上午
 * @since 1.0
 */
public enum CommandEnum {
  /**
   * 重新加载xml文件
   */
  RELOAD_XML("reloadxml");


  @Getter
  @Setter
  private String command;


  CommandEnum(String command) {
    this.command = command;
  }
}

