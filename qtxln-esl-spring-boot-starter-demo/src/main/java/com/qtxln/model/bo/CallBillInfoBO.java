package com.qtxln.model.bo;

import lombok.Data;

/**
 * 话单详情BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 18:37
 * @since 1.0
 */
@Data
public class CallBillInfoBO {

  /**
   * 描述
   */
  private String describe;

  /**
   * 事件名
   */
  private String eventName;

  /**
   * 时间
   */
  private String eventDateLocal;

}
