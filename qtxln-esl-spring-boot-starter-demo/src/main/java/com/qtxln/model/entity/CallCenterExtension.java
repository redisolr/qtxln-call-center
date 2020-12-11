package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 分机表
 * </p>
 *
 * @author 秦腾
 * @since 2020-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CallCenterExtension extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 9137521372938228515L;
  /**
   * 坐席通话后启用后处理功能
   */
  @TableField("is_after_process")
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
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /**
   * 媒体文件id
   */
  private Long mediaId;
  /**
   * 允许外呼
   */
  @TableField("is_outbound")
  private Boolean outbound;
  /**
   * 密码
   */
  private String password;
  /**
   * 播报工号
   */
  @TableField("is_play_job_num")
  private Boolean playJobNum;
  /**
   * sip网关
   */
  private String sipTrunk;
  /**
   * 允许录音
   */
  @TableField("is_sound_recording")
  private Boolean soundRecording;
  /**
   * 分机类型
   */
  private String type;
  /**
   * 启用WebRTC
   */
  @TableField("is_web_rtc")
  private Boolean webRtc;


}
