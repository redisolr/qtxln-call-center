package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 字典数据BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/14 11:21 上午
 * @since 1.0
 */
@Data
public class SysDictionaryVO {

  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {GroupUpdate.class})
  private Long id;

  @ApiModelProperty("字典名称")
  @NotBlank(message = "字典名称不能为空", groups = {GroupInsert.class})
  private String dicName;

  @ApiModelProperty("字典代码")
  @NotBlank(message = "字典代码不能为空", groups = {GroupInsert.class})
  private String dicCode;

  @ApiModelProperty("描述")
  private String dicDescribe;

  @ApiModelProperty("父id")
  private Long parentId;

  @ApiModelProperty("排序值")
  @NotNull(message = "排序值不能为空", groups = {GroupInsert.class})
  private Integer sortValue;

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

