package com.qtxln.model.bo;

import lombok.Data;

/**
 * 分机表BO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/30 15:11 下午
 * @since 1.0
 */
@Data
public class CallCenterExtensionBO {

  /**
   * 坐席通话后启用后处理功能
   */
  private Boolean afterProcess;
  /**
   * 坐席工号
   */
  private String agentNumber;
  /**
   * 描述
   */
  private String description;
  /**
   * 分机名称
   */
  private String extensionName;
  /**
   * 分机号
   */
  private String extensionNumber;
  /**
   * 外呼显示名称
   */
  private String outboundName;
  /**
   * 外呼显示号码
   */
  private String outboundNumber;
  /**
   * fs服务器id
   */
  private Long fsId;
  /**
   * 主键
   */
  private Long id;
  /**
   * 媒体文件id
   */
  private Long mediaId;
  /**
   * 允许外呼
   */
  private Boolean outbound;
  /**
   * 密码
   */
  private String password;
  /**
   * 播报工号
   */
  private Boolean playJobNum;
  /**
   * sip网关
   */
  private String sipTrunk;
  /**
   * 允许录音
   */
  private Boolean soundRecording;
  /**
   * 分机类型
   */
  private String type;
  /**
   * 启用WebRTC
   */
  private Boolean webRtc;

  private Integer pageNum;

  private Integer pageSize;

}
