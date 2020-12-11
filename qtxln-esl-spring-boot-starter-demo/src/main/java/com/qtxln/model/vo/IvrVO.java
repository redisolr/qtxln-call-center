package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * IVR VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-10-10 09:54
 * @since 1.0
 */
@Data
public class IvrVO {

  /**
   * 主键
   */
  private Long id;

  /**
   * ivr名称
   */
  private String ivrName;

  /**
   * 欢迎音
   */
  private String greatLong;

  /**
   * 简短提示音
   */
  private String greetShort;

  /**
   * 按键错误提示音
   */
  private String invalidSound;

  /**
   * 退出(超时)提示音
   */
  private String exitSound;

  /**
   * 转接提示音
   */
  private String transSound;

  /**
   * 超时时间(单位:毫秒)
   */
  private Integer timeout;

  /**
   * 最大错误按键次数
   */
  private Integer maxFailures;

  /**
   * 最大超时次数
   */
  private Integer maxTimeouts;

  /**
   * 两次按键的最大时间间隔(单位:毫秒)
   */
  private Integer interDigitTimeout;

  /**
   * 菜单长度
   */
  private Integer digitLen;

  /**
   * 父id
   */
  private Long parentId;

  /**
   * 描述
   */
  private String description;

  /**
   * ivr图
   */
  private String ivrGraph;

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
