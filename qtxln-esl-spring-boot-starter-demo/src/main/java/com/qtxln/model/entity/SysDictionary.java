package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysDictionary extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -8317878575605618017L;
  /**
   * 代码
   */
  private String dicCode;
  /**
   * 描述
   */
  private String dicDescribe;
  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /**
   * 字典名
   */
  private String dicName;
  /**
   * 父id
   */
  private Long parentId;

  /**
   * 排序值
   */
  private Integer sortValue;

}
