package com.qtxln.model.bo;

import lombok.Data;

/**
 * 文件信息BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/5 16:55 下午
 * @since 1.0
 */
@Data
public class FileBO {

  private String fileName;
  private String originalFileName;
  private String type;
  private Long size;

}

