package com.qtxln.model.bo;

import lombok.Data;

/**
 * 拨号计划BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-08 14:07
 * @since 1.0
 */
@Data
public class DialplanBO {

  /**
   * id
   */
  private Long id;

  /**
   * 中文名
   */
  private String dialplanChineseName;

  /**
   * 英文名
   */
  private String dialplanEnglishName;

  /**
   * 正则表达式
   */
  private String regularRules;

  /**
   * 类型(字段值)
   */
  private String dialplanType;

  /**
   * 描述
   */
  private String description;

  /**
   * 拨号计划内容
   */
  private String dialplanContent;

  /**
   * 拨号计划模板id数组
   */
  private String dialplanTemplateArr;

  private Integer pageNum;

  private Integer pageSize;

}
