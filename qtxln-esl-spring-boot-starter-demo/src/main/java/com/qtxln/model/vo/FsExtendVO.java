package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 服务器扩展信息VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/11 23:19 下午
 * @since 1.0
 */
@Data
public class FsExtendVO {

  @ApiModelProperty("主键")
  @NotNull(message = "更新id不能为空", groups = {FsBasicVO.GroupUpdate.class})
  private Long id;

  @ApiModelProperty("FS基本信息id")
  private Long fsBasicId;

  @ApiModelProperty("FS安装路径")
  private String path;

  @ApiModelProperty("语音设备类型")
  private String voiceDeviceType;

  @ApiModelProperty("录音文件位置")
  private String recordPath;

  @ApiModelProperty("SIP类型(语音服务分机注册类型)")
  private String sipType;

  @ApiModelProperty("是否自动应答")
  private Boolean autoAnswer;

  @ApiModelProperty("sip是否自动应答")
  private Boolean sipAutoAnswer;

  @ApiModelProperty("是否启用呼叫中心")
  private Boolean callCenter;

  @ApiModelProperty("坐席通话后是否启用后处理功能")
  private Boolean afterProcess;

  @ApiModelProperty("通信编码")
  private String absCodec;

  @ApiModelProperty("是否启用webRtc")
  private Boolean webRtc;

  @ApiModelProperty("webRtc地址")
  private String webRtcAddress;

  @ApiModelProperty("webRtc端口")
  private Integer webRtcPort;

  @ApiModelProperty("SIP服务端口")
  private Integer sipPort;

  @ApiModelProperty("webRtc启用SSL")
  private Boolean webRtcSsl;

  @ApiModelProperty("来点铃声")
  private String webRtcRing;

  @ApiModelProperty("外呼隐藏号码")
  private Boolean hiddenNumber;

  @ApiModelProperty("最小号码长度")
  private Integer minNumLength;

  @ApiModelProperty("最大号码长度")
  private Integer maxNumLength;

  @ApiModelProperty("黑名单筛选条件")
  private String blacklist;

  @ApiModelProperty("白名单筛选条件")
  private String whitelist;

  @ApiModelProperty("黑名单ip地区")
  private String blacklistIpArea;

  @ApiModelProperty("白名单ip地区")
  private String whitelistIpArea;

  @ApiModelProperty("是否保存呼叫拦截记录")
  private Boolean callBlockingRecord;

  /**
   * 更新分组
   */
  public interface GroupUpdate {
  }

}
