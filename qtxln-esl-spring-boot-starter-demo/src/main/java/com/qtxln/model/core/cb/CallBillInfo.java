package com.qtxln.model.core.cb;

import lombok.Data;

/**
 * 话单详情
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-10 11:37
 * @since 1.0
 */
@Data
public class CallBillInfo {

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
