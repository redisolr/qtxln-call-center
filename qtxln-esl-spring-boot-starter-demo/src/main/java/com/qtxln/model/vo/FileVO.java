package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * 文件信息VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/5 16:55 下午
 * @since 1.0
 */
@Data
public class FileVO {

  @ApiModelProperty("文件名称")
  private String fileName;
  @ApiModelProperty("原始文件名")
  private String originalFileName;
  @ApiModelProperty("文件类型")
  private String type;
  @ApiModelProperty("文件大小")
  private Long size;

  @ApiModelProperty("上传文件")
  @NotNull(message = "上传文件不能为空", groups = {GroupInsert.class})
  private MultipartFile file;

  /**
   * 添加分组
   */
  public interface GroupInsert {
  }

}

