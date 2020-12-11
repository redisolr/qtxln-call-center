package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 拨号计划VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-08 14:19
 * @since 1.0
 */
@Data
public class DialplanVO {

  @ApiModelProperty("主键")
  private Long id;

  @ApiModelProperty("中文名")
  private String dialplanChineseName;

  @ApiModelProperty("英文名")
  private String dialplanEnglishName;

  @ApiModelProperty("正则表达式")
  private String regularRules;

  @ApiModelProperty("类型(字段值)")
  private String dialplanType;

  @ApiModelProperty("描述")
  private String description;

  @ApiModelProperty("拨号计划内容")
  private String dialplanContent;

  @ApiModelProperty("拨号计划模板id数组")
  private String dialplanTemplateArr;

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
