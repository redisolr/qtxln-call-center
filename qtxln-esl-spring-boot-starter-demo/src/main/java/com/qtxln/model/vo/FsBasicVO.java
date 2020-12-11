package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 服务器基本信息VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/5 22:02 下午
 * @since 1.0
 */
@Data
public class FsBasicVO {

  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {GroupUpdate.class})
  private Long id;

  @ApiModelProperty("FS名称")
  @NotBlank(message = "FS名称不能为空", groups = {GroupInsert.class})
  private String name;

  @ApiModelProperty("主机名")
  @NotBlank(message = "主机名称不能为空", groups = {GroupInsert.class})
  private String hostName;

  @ApiModelProperty("ip地址")
  @NotBlank(message = "ip地址不能为空", groups = {GroupInsert.class})
  private String hostIp;

  @ApiModelProperty("端口")
  @NotNull(message = "端口不能为空", groups = {GroupInsert.class})
  private Integer port;

  @ApiModelProperty("密码")
  @NotBlank(message = "密码不能为空", groups = {GroupInsert.class})
  private String password;

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
