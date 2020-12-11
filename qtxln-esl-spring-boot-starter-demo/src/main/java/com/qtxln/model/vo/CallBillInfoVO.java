package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 话单详情VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 18:34
 * @since 1.0
 */
@Data
public class CallBillInfoVO {

  @ApiModelProperty("事件名称")
  private String eventName;
  @ApiModelProperty("事件时间")
  private String eventDateLocal;
  @ApiModelProperty("描述")
  private String describe;

}
