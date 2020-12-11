package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 拨号计划模板VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/7 16:42 下午
 * @since 1.0
 */
@Data
public class DialplanTemplateVO {

  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {GroupUpdate.class})
  private Long id;

  @ApiModelProperty("拨号计划app id")
  @NotNull(message = "拨号计划app id不能为空", groups = {GroupInsert.class})
  private Long dialplanAppId;

  @ApiModelProperty("拨号计划app值")
  @NotNull(message = "拨号计划app值不能为空", groups = {GroupInsert.class})
  private String dialplanAppValue;

  @ApiModelProperty("拨号计划模板作用")
  @NotNull(message = "拨号计划模板作用不能为空", groups = {GroupInsert.class})
  private String dialplanTemplateEffect;

  @ApiModelProperty("拨号计划模板分类id")
  @NotNull(message = "拨号计划模板分类id不能为空", groups = {GroupInsert.class})
  private Long dialplanTemplateClassId;

  @ApiModelProperty("拨号计划app名称")
  private String dialplanAppName;

  @ApiModelProperty("拨号计划模板分类名称")
  private String dialplanTemplateClassName;

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
