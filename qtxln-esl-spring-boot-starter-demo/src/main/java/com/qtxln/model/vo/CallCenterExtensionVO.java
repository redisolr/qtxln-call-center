package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 分机信息VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/31 15:34 下午
 * @since 1.0
 */
@Data
public class CallCenterExtensionVO {

  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {GroupUpdate.class})
  private Long id;

  /**
   * fs服务器id
   */
  private Long fsId;

  @ApiModelProperty("分机名称")
  private String extensionName;

  @ApiModelProperty("分机号")
  @NotBlank(message = "分机号不能为空", groups = {GroupInsert.class})
  private String extensionNumber;

  /**
   * 外呼显示名称
   */
  private String outboundName;
  /**
   * 外呼显示号码
   */
  private String outboundNumber;

  /**
   * 坐席工号
   */
  private String agentNumber;

  @ApiModelProperty("密码")
  @NotBlank(message = "密码不能为空", groups = {GroupInsert.class})
  private String password;

  /**
   * 允许外呼
   */
  private Boolean outbound;

  /**
   * 播报工号
   */
  private Boolean playJobNum;

  /**
   * 媒体文件id
   */
  private Long mediaId;

  /**
   * 坐席通话后启用后处理功能
   */
  private Boolean afterProcess;

  /**
   * 允许录音
   */
  private Boolean soundRecording;

  /**
   * 启用WebRTC
   */
  private Boolean webRtc;

  /**
   * 描述
   */
  private String description;

  /**
   * sip网关
   */
  private String sipTrunk;

  /**
   * 分机类型
   */
  private String type;

  @ApiModelProperty("页码")
  @NotNull(message = "页码不能为空", groups = {CallCenterMediaVO.GroupQuery.class})
  private Integer pageNum;

  @ApiModelProperty("查询长度")
  @NotNull(message = "查询长度不能为空", groups = {CallCenterMediaVO.GroupQuery.class})
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
