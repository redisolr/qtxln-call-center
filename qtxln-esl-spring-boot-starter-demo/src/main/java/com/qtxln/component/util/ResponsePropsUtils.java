package com.qtxln.component.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.dialect.Props;

/**
 * 获取 输出编码对应的描述
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 18:51 下午
 * @since 1.0
 */
public final class ResponsePropsUtils {

  private static final Props PROPS;

  static {
    PROPS = new Props("properties/response.properties", CharsetUtil.CHARSET_UTF_8);
  }

  private ResponsePropsUtils() {
  }

  /**
   * 输出编码对应的描述
   *
   * @param key        key值
   * @param defaultVal 如果不存在，则返回defaultVal
   * @return 结果
   */
  public static String getByKey(String key, String defaultVal) {
    return PROPS.getProperty(key, defaultVal);
  }

  /**
   * 输出编码对应的描述
   *
   * @param key key值
   * @return 结果
   */
  public static String getByKey(String key) {
    return PROPS.getProperty(key);
  }

}

