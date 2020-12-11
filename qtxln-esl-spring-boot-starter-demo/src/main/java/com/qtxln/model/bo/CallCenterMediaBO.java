package com.qtxln.model.bo;

import lombok.Data;

/**
 * 呼叫中心媒体BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/30 15:11 下午
 * @since 1.0
 */
@Data
public class CallCenterMediaBO {

  /**
   * id
   */
  private Long id;

  /**
   * 名称
   */
  private String businessName;

  /**
   * fs服务器id
   */
  private Long fsId;

  /**
   * 描述
   */
  private String description;

  /**
   * 原始文件名称
   */
  private String originalFileName;
  /**
   * 文件大小(单位:字节)
   */
  private Long size;
  /**
   * 文件类型
   */
  private String type;
  /**
   * 文件名称
   */
  private String fileName;

  private Integer pageNum;

  private Integer pageSize;

}
