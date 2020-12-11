package com.qtxln.model.bo;

import lombok.Data;

/**
 * IVR Entry BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-10-10 10:38
 * @since 1.0
 */
@Data
public class IvrEntryBO {

  /**
   * 主键
   */
  private Long id;

  /**
   * ivrId
   */
  private Long ivrId;

  /**
   * 名称
   */
  private String name;

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

  private String ivrName;

  private String typeName;

  private Integer pageNum;

  private Integer pageSize;

}
