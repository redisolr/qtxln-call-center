package com.qtxln.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.qtxln.component.util.ali.OssUtils;
import com.qtxln.model.bo.FileBO;
import com.qtxln.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * 公共服务实现类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/5 16:09 下午
 * @since 1.0
 */
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

  @Override
  public FileBO uploadFile(MultipartFile file) {
    FileBO fileBO = new FileBO();
    String originalFilename = file.getOriginalFilename();
    fileBO.setOriginalFileName(originalFilename);
    String contentType = file.getContentType();
    fileBO.setType(contentType);
    long size = file.getSize();
    fileBO.setSize(size);
    try (InputStream inputStream = file.getInputStream()) {
      String md5FileName = SecureUtil.md5(inputStream);
      String fileName = md5FileName + '.' + Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf(".") + 1);
      fileBO.setFileName(fileName);
      if (!OssUtils.doesObjectExist(fileName)) {
        OssUtils.upload(file, fileName);
      }
    } catch (IOException e) {
      log.error("获取文件信息异常", e);
    }
    return fileBO;
  }

}

