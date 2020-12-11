package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IvrEntry extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 3349409399319595039L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 名称
   */
  private String name;

  /**
   * ivrId
   */
  private Long ivrId;

  /**
   * action类型
   */
  private String type;

  /**
   * 按键
   */
  private String digits;

  /**
   * 参数
   */
  private String param;

  @TableField(exist = false)
  private String ivrName;

  @TableField(exist = false)
  private String typeName;


}
