package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * IVR Entry VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-10-10 10:40
 * @since 1.0
 */
@Data
public class IvrEntryVO {

  /**
   * 主键
   */
  private Long id;

  /**
   * ivrId
   */
  private Long ivrId;

  /**
   * 名称
   */
  private String name;

  /**
   * action类型
   */
  private String type;

  /**
   * 按键
   */
  private String digits;

  /**
   * 参数
   */
  private String param;

  private String ivrName;

  private String typeName;

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
