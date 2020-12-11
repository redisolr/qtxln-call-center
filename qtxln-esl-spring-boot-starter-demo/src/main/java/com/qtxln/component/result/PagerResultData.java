package com.qtxln.component.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 带分页的数据
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 19:25 下午
 * @since 1.0
 */
@Data
@ApiModel("带分页的数据")
public class PagerResultData<T> {

  @ApiModelProperty(value = "数据")
  private T list;
  @ApiModelProperty(value = "分页")
  private Pager pager;

  public PagerResultData(T data, Pager pager) {
    this.list = data;
    this.pager = pager;
  }

}

