package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 呼叫中心-媒体资源表
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CallCenterMedia extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 881708087282985367L;

  /**
   * 描述
   */
  private String description;
  /**
   * 文件名称
   */
  private String fileName;
  /**
   * fs服务器id
   */
  private Long fsId;
  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /**
   * 名称
   */
  private String businessName;
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

}
