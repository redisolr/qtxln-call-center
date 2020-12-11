package com.qtxln.service;

import com.qtxln.model.bo.FileBO;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共服务
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/5 16:09 下午
 * @since 1.0
 */
public interface CommonService {

  /**
   * 上传文件
   * @param file 文件
   * @return 文件信息
   */
  FileBO uploadFile(MultipartFile file);

}

