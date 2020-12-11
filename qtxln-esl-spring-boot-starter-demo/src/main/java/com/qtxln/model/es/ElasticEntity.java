package com.qtxln.model.es;

import lombok.Data;

import java.util.Map;

/**
 * es实体
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-08 17:45
 * @since 1.0
 */
@Data
public class ElasticEntity {

  /**
   * 主键标识，用户ES持久化
   */
  private String id;

  /**
   * JSON对象，实际存储数据
   */
  private Map<String, String> data;

}
