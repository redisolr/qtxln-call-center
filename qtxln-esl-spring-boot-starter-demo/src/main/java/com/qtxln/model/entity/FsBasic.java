package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * FS基本信息
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FsBasic extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 7495031256248286529L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * FS名称
   */
  private String name;

  /**
   * 主机名
   */
  private String hostName;

  /**
   * ip地址
   */
  private String hostIp;

  /**
   * 端口
   */
  private Integer port;

  /**
   * 密码
   */
  private String password;

}
