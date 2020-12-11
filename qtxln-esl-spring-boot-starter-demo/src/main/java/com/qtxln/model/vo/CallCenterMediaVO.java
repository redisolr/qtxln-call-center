package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 呼叫中心媒体VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/30 15:11 下午
 * @since 1.0
 */
@Data
public class CallCenterMediaVO {

  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {GroupUpdate.class})
  private Long id;

  @ApiModelProperty("名称")
  @NotBlank(message = "名称不能为空", groups = {GroupInsert.class})
  private String businessName;

  @ApiModelProperty("fs服务器id")
  private Long fsId;

  @ApiModelProperty("描述")
  private String description;

  @ApiModelProperty("文件名")
  @NotBlank(message = "文件名不能为空", groups = {GroupInsert.class})
  private String fileName;

  @ApiModelProperty("原始文件名")
  @NotBlank(message = "原始文件名不能为空", groups = {GroupInsert.class})
  private String originalFileName;

  @ApiModelProperty("文件大小")
  private Long size;

  @ApiModelProperty("文件类型")
  @NotBlank(message = "文件类型不能为空", groups = {GroupInsert.class})
  private String type;

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
