package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 拨号计划-模板表
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DialplanTemplate extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 6829185599618237130L;
  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
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
  @TableField(exist = false)
  private String dialplanAppName;

  /**
   * 拨号计划模板分类名称
   */
  @TableField(exist = false)
  private String dialplanTemplateClassName;

}
