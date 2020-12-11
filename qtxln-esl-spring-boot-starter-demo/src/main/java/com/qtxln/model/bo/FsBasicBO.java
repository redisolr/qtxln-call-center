package com.qtxln.model.bo;

import lombok.Data;

/**
 * 服务器基本信息BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/5 22:02 下午
 * @since 1.0
 */
@Data
public class FsBasicBO {

  /**
   * id
   */
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

  private Integer pageNum;

  private Integer pageSize;

}
