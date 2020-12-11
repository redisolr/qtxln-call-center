package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 拨号计划-app表
 * </p>
 *
 * @author 秦腾
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DialplanApplication extends BaseEntity implements Serializable {

  private static final long serialVersionUID = -7010424495673011761L;
  /**
   * app含义
   */
  private String applicationMeaning;
  /**
   * app名称
   */
  private String applicationName;
  /**
   * fs服务器id
   */
  private Long fsId;
  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

}
