package com.qtxln.model.bo;

import lombok.Data;

/**
 * 字典数据BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/14 11:21 上午
 * @since 1.0
 */
@Data
public class SysDictionaryBO {

  /**
   * 主键
   */
  private Long id;
  /**
   * 代码
   */
  private String dicCode;
  /**
   * 描述
   */
  private String dicDescribe;
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

  private Integer pageNum;

  private Integer pageSize;

}

