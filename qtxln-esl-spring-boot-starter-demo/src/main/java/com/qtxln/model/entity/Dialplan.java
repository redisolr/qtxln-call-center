package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 拨号计划表
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Dialplan extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -5016476705348474399L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
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

}
