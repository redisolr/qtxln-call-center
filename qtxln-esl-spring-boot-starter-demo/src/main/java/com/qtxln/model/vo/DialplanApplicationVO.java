package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 拨号计划app VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/6 17:25 下午
 * @since 1.0
 */
@Data
public class DialplanApplicationVO {

  /**
   * 主键
   */
  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {GroupUpdate.class})
  private Long id;

  @ApiModelProperty("app含义")
  @NotBlank(message = "含义不能为空", groups = {GroupInsert.class})
  private String applicationMeaning;

  @ApiModelProperty("app名称")
  @NotBlank(message = "app名称不能为空", groups = {GroupInsert.class})
  private String applicationName;
  /**
   * fs服务器id
   */
  private Long fsId;

  @ApiModelProperty("页码")
  @NotNull(message = "页码不能为空", groups = {GroupQuery.class})
  private Integer pageNum;

  @ApiModelProperty("查询长度")
  @NotNull(message = "查询长度不能为空", groups = {GroupQuery.class})
  private Integer pageSize;

  /**
   * 查询分组
   */
  public interface GroupQuery {
  }

  /**
   * 添加分组
   */
  public interface GroupInsert {
  }

  /**
   * 更新分组
   */
  public interface GroupUpdate {
  }

}
