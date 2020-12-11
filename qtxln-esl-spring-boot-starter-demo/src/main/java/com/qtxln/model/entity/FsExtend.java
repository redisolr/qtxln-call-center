package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * FS服务器扩展信息
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FsExtend extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 6867104615386511635L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
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
  @TableField(value = "is_auto_answer")
  private Boolean autoAnswer;

  /**
   * sip是否自动应答
   */
  @TableField(value = "is_sip_auto_answer")
  private Boolean sipAutoAnswer;

  /**
   * 是否启用呼叫中心
   */
  @TableField(value = "is_call_center")
  private Boolean callCenter;

  /**
   * 坐席通话后是否启用后处理功能
   */
  @TableField(value = "is_after_process")
  private Boolean afterProcess;

  /**
   * 通信编码
   */
  private String absCodec;

  /**
   * 是否启用webRtc
   */
  @TableField(value = "is_web_rtc")
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
  @TableField(value = "is_web_rtc_ssl")
  private Boolean webRtcSsl;

  /**
   * 来点铃声
   */
  private String webRtcRing;

  /**
   * 外呼隐藏号码
   */
  @TableField(value = "is_hidden_number")
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
  @TableField(value = "is_call_blocking_record")
  private Boolean callBlockingRecord;

}
