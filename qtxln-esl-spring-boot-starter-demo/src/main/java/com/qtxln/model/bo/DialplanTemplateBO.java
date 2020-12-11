package com.qtxln.model.bo;

import lombok.Data;

/**
 * 拨号计划模板BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/7 16:55 下午
 * @since 1.0
 */
@Data
public class DialplanTemplateBO {

  /**
   * 主键
   */
  private Long id;

  /**
   * 拨号计划appid
   */
  private Long dialplanAppId;

  /**
   * 拨号计划app参数值
   */
  private String dialplanAppValue;

  /**
   * 模板作用
   */
  private String dialplanTemplateEffect;

  /**
   * 模板分类id
   */
  private Long dialplanTemplateClassId;

  /**
   * 拨号计划app名称
   */
  private String dialplanAppName;

  /**
   * 拨号计划模板分类名称
   */
  private String dialplanTemplateClassName;

  private Integer pageNum;

  private Integer pageSize;

}
