package com.qtxln.model.bo;

import lombok.Data;


/**
 * 拨号计划app BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/6 17:25 下午
 * @since 1.0
 */
@Data
public class DialplanApplicationBO {

  /**
   * 主键
   */
  private Long id;
  /**
   * app含义
   */
  private String applicationMeaning;

  /**
   * app名称
   */
  private String applicationName;
  /**
   * fs服务器id
   */
  private Long fsId;

  private Integer pageNum;

  private Integer pageSize;

}
