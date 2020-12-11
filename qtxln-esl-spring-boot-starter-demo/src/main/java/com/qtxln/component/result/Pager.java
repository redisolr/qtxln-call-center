package com.qtxln.component.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Pager
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/7 19:20 下午
 * @since 1.0
 */
@Data
@AllArgsConstructor
@ApiModel("Pager")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pager {

  @ApiModelProperty(value = "页码", example = "0")
  @JsonProperty(value = "pageNum")
  private Long pageNum;
  @ApiModelProperty(value = "单页记录条数", example = "10")
  @JsonProperty(value = "pageSize")
  private Long pageSize;
  @ApiModelProperty(value = "记录总数", example = "10")
  @JsonProperty(value = "total")
  private Long total;

  public static Pager setPager(Long pageNum, Long pageSize, Long total) {
    return new Pager(pageNum, pageSize, total);
  }

}

