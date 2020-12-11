package com.qtxln.model.bo;

import lombok.Data;

/**
 * 服务器扩展信息BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/11 23:19 下午
 * @since 1.0
 */
@Data
public class FsExtendBO {

  /**
   * 主键
   */
  private Long id;
  /**
   * FS基本信息id
   */
  private Long fsBasicId;

  /**
   * FS安装路径
   */
  private String path;

  /**
   * 语音设备类型
   */
  private String voiceDeviceType;

  /**
   * 录音文件位置
   */
  private String recordPath;

  /**
   * SIP类型(语音服务分机注册类型)
   */
  private String sipType;

  /**
   * 是否自动应答
   */
  private Boolean autoAnswer;

  /**
   * sip是否自动应答
   */
  private Boolean sipAutoAnswer;

  /**
   * 是否启用呼叫中心
   */
  private Boolean callCenter;

  /**
   * 坐席通话后是否启用后处理功能
   */
  private Boolean afterProcess;

  /**
   * 通信编码
   */
  private String absCodec;

  /**
   * 是否启用webRtc
   */
  private Boolean webRtc;

  /**
   * webRtc地址
   */
  private String webRtcAddress;

  /**
   * webRtc端口
   */
  private Integer webRtcPort;

  /**
   * SIP服务端口
   */
  private Integer sipPort;

  /**
   * webRtc启用SSL
   */
  private Boolean webRtcSsl;

  /**
   * 来点铃声
   */
  private String webRtcRing;

  /**
   * 外呼隐藏号码
   */
  private Boolean hiddenNumber;

  /**
   * 最小号码长度
   */
  private Integer minNumLength;

  /**
   * 最大号码长度
   */
  private Integer maxNumLength;

  /**
   * 黑名单筛选条件
   */
  private String blacklist;

  /**
   * 白名单筛选条件
   */
  private String whitelist;

  /**
   * 黑名单ip地区
   */
  private String blacklistIpArea;

  /**
   * 白名单ip地区
   */
  private String whitelistIpArea;

  /**
   * 是否保存呼叫拦截记录
   */
  private Boolean callBlockingRecord;

}
