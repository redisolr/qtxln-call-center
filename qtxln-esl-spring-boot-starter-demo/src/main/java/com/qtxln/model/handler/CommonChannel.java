package com.qtxln.model.handler;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * CommonChannel
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/6/6 17:29 下午
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonChannel extends CommonField {

  /**
   * 当前Channel的状态
   */
  @JSONField(alternateNames = "Channel-State")
  private String channelState;
  /**
   * 当前Channel的状态整数值
   */
  @JSONField(alternateNames = "Channel-State-Number")
  private String channelStateNumber;
  /**
   * Channel名
   */
  @JSONField(alternateNames = "Channel-Name")
  private String channelName;
  /**
   * Channel的UUID
   */
  @JSONField(alternateNames = "Unique-ID")
  private String uniqueId;
  /**
   * 呼叫方向 Inbound或Outbound
   */
  @JSONField(alternateNames = "Call-Direction")
  private String callDirection;
  /**
   * 应答状态  (ringing 振铃)
   */
  @JSONField(alternateNames = "Answer-State")
  private String answerState;

  /**
   * 读Codec
   */
  @JSONField(alternateNames = "Channel-Read-Codec-Name")
  private String channelReadCodecName;
  /**
   * 读采样率
   */
  @JSONField(alternateNames = "Channel-Read-Codec-Rate")
  private String channelReadCodecRate;
  /**
   * 写Codec
   */
  @JSONField(alternateNames = "Channel-Write-Codec-Name")
  private String channelWriteCodecName;
  /**
   * 写采样率
   */
  @JSONField(alternateNames = "Channel-Write-Codec-Rate")
  private String channelWriteCodecRate;
  /**
   * 用户名
   */
  @JSONField(alternateNames = "Caller-Username")
  private String callerUsername;

  /**
   * 使用的Dialplan,如XML、lua、enum、lcr等
   */
  @JSONField(alternateNames = "Caller-Dialplan")
  private String callerDialplan;

  /**
   * 主叫号码
   */
  @JSONField(alternateNames = "Caller-Caller-ID-Number")
  private String callerCallerIdNumber;
  /**
   * 主叫名称
   */
  @JSONField(alternateNames = "Caller-Caller-ID-Name")
  private String callerCallerIdName;

  /**
   * 主叫号码
   */
  @JSONField(alternateNames = "Caller-Callee-ID-Number")
  private String callerCalleeIdNumber;
  /**
   * 本地媒体ip
   */
  @JSONField(alternateNames = "variable_local_media_ip")
  private String variableLocalMediaIp;

  /**
   * 主叫Ani,一般与caller_id_number相同
   */
  @JSONField(alternateNames = "Caller-ANI")
  private String callerAni;

  /**
   * 主叫ip
   */
  @JSONField(alternateNames = "Caller-Network-Addr")
  private String callerNetworkAddr;

  /**
   * 被叫号码
   */
  @JSONField(alternateNames = "Caller-Destination-Number")
  private String callerDestinationNumber;

  /**
   * Channel UUID 呼叫者(主叫)唯一id
   */
  @JSONField(alternateNames = "Caller-Unique-ID")
  private String callerUniqueId;
  /**
   * 呼叫来源,如mod_sofia、mod_freetdm等
   */
  @JSONField(alternateNames = "Caller-Source")
  private String callerSource;
  /**
   * Dialplan Context
   */
  @JSONField(alternateNames = "Caller-Context")
  private String callerContext;

  // Caller-RDNIS

  /**
   * Channel的名称
   */
  @JSONField(alternateNames = "Caller-Channel-Name")
  private String callerChannelName;
  /**
   * 配置文件索引
   */
  @JSONField(alternateNames = "Caller-Profile-Index")
  private String callerProfileIndex;
  /**
   * 创建时间
   */
  @JSONField(alternateNames = "Caller-Channel-Created-Time")
  private String callerChannelCreatedTime;
  /**
   * 应答时间
   */
  @JSONField(alternateNames = "Caller-Channel-Answered-Time")
  private String callerChannelAnsweredTime;
  /**
   * 挂机时间
   */
  @JSONField(alternateNames = "Caller-Channel-Hangup-Time")
  private String callerChannelHangupTime;
  /**
   * 转移时间
   */
  @JSONField(alternateNames = "Caller-Channel-Transfer-Time")
  private String callerChannelTransferTime;

  @JSONField(alternateNames = "Event-Date-Local")
  private String eventDateLocal;

}

