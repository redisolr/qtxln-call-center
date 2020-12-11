package com.qtxln.component.util.ali;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * OssUtils
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/30 14:10 下午
 * @since 1.0
 */
@Slf4j
public class OssUtils {

  private OssUtils() {
  }

  private static final String END_POINT = "http://oss-cn-beijing.aliyuncs.com";
  private static final String ACCESS_KEY_ID = "LTAIi11bzO1F3IWm";
  private static final String ACCESS_KEY_SECRET = "g1JRyVRGz5AlKZ6YwyPYFEmGM3aRlj";
  private static final String BUCKET_NAME_DEFAULT = "free-switch";

  public static String upload(MultipartFile file, String fileName) {
    OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    try (InputStream inputStream = file.getInputStream()) {
      ossClient.putObject(BUCKET_NAME_DEFAULT, fileName, inputStream);
    } catch (IOException e) {
      log.error("上传文件失败", e);
    } finally {
      ossClient.shutdown();
    }
    return fileName;
  }

  public static boolean doesObjectExist(String fileName) {
    OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    boolean result = ossClient.doesObjectExist(BUCKET_NAME_DEFAULT, fileName);
    // 关闭OSSClient。
    ossClient.shutdown();
    return result;
  }

}

