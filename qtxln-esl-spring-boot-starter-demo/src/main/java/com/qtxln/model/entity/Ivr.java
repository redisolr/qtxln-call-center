package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * IVR
 * </p>
 *
 * @author 秦腾
 * @since 2020-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Ivr extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 6880665027061902725L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
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

}
