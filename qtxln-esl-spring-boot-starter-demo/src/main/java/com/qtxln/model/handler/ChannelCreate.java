package com.qtxln.model.handler;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ChannelCreate 通道创建
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/21 14:16 下午
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChannelCreate extends CommonChannel{

  /**
   * 本地媒体端口  19024
   */
  @JSONField(alternateNames = "variable_local_media_port")
  private String variableLocalMediaPort;
  /**
   * sip发送的主机    t-12368hotline.aegis-info.com
   */
  @JSONField(alternateNames = "variable_sip_to_host")
  private String variableSipToHost;
  /**
   * sip请求参数   intercom=true
   */
  @JSONField(alternateNames = "variable_sip_invite_params")
  private String variableSipInviteParams;
  /**
   * 通道显示id  199301@192.168.3.246
   */
  @JSONField(alternateNames = "Channel-Presence-ID")
  private String channelPresenceId;
  /**
   * 音频媒体流 sendrecv
   */
  @JSONField(alternateNames = "variable_audio_media_flow")
  private String variableAudioMediaFlow;
  /**
   * 呼叫着(主叫)唯一id   da68df21-b411-4346-a904-72405bb4e2f2
   */
  @JSONField(alternateNames = "Caller-Unique-ID")
  private String callerUniqueId;
  /**
   * 呼叫方通道进程媒体时间   0
   */
  @JSONField(alternateNames = "Caller-Channel-Progress-Media-Time")
  private String callerChannelProgressMediaTime;



  /**
   * sdp 字符串数据
   */
  @JSONField(alternateNames = "variable_rtp_local_sdp_str")
  private String variableRtpLocalSdpStr;
  /**
   * 通话点击拨号规则
   */
  @JSONField(alternateNames = "Channel-HIT-Dialplan")
  private String channelHitDialplan;
  /**
   * 呼叫者通道最后保持时间
   */
  @JSONField(alternateNames = "Caller-Channel-Last-Hold")
  private String callerChannelLastHold;
  /**
   * 会话id  1586
   */
  @JSONField(alternateNames = "variable_session_id")
  private String variableSessionId;
  /**
   * 呼叫者被呼叫者id名称
   */
  @JSONField(alternateNames = "Caller-Callee-ID-Name")
  private String callerCalleeIdName;
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
   * uuid
   */
  @JSONField(alternateNames = "variable_uuid")
  private String variableUuid;
  /**
   * 恢复配置文件名
   */
  @JSONField(alternateNames = "variable_recovery_profile_name")
  private String variableRecoveryProfileName;
  /**
   * 呼叫方向   outbound
   */
  @JSONField(alternateNames = "Presence-Call-Direction")
  private String presenceCallDirection;
  /**
   * 会叫方向   outbound
   */
  @JSONField(alternateNames = "Caller-Direction")
  private String callerDirection;
  /**
   * 呼叫uuid
   */
  @JSONField(alternateNames = "variable_call_uuid")
  private String variableCallUuid;
  /**
   * 方向
   */
  @JSONField(alternateNames = "variable_direction")
  private String variableDirection;
  /**
   * sip网络地址
   */
  @JSONField(alternateNames = "variable_sip_local_network_addr")
  private String variableSipLocalNetworkAddr;
  /**
   * 主叫配置文件创建时间
   */
  @JSONField(alternateNames = "Caller-Profile-Created-Time")
  private String callerProfileCreateTime;
  /**
   * 拨号用户
   */
  @JSONField(alternateNames = "variable_dialed_user")
  private String variableDialedUser;
  /**
   * 呼叫状态
   */
  @JSONField(alternateNames = "Channel-Call-State")
  private String channelCallState;
  /**
   * sip 邀请域
   */
  @JSONField(alternateNames = "variable_sip_invite_domain")
  private String variableSipInviteDomain;
  /**
   * 呼叫者屏蔽位
   */
  @JSONField(alternateNames = "Caller-Screen-Bit")
  private String callerScreenBit;
  /**
   * 媒体webrtc
   */
  @JSONField(alternateNames = "variable_media_webrtc")
  private String variableMediaWebRtc;
  /**
   * 呼叫者逻辑方向
   */
  @JSONField(alternateNames = "Caller-Logical-Direction")
  private String callerLogicalDirection;
  /**
   * 拨号域
   */
  @JSONField(alternateNames = "variable_dialed_domain")
  private String variableDialedDomain;
  /**
   * 通道名
   */
  @JSONField(alternateNames = "variable_channel_name")
  private String variableChannelName;
  /**
   * sip配置文件名
   */
  @JSONField(alternateNames = "variable_sip_profile_name")
  private String variableSipProfileName;
  /**
   * 呼叫者id名
   */
  @JSONField(alternateNames = "Caller-Orig-Caller-ID-Name")
  private String callerOrigCallerIdName;
  /**
   *
   */
  @JSONField(alternateNames = "variable_sip_h_Call-Info")
  private String variableSipHCallInfo;
  /**
   * sip目的地url
   */
  @JSONField(alternateNames = "variable_sip_destination_url")
  private String variableSipDestinationUrl;
  /**
   * 编码  PCMA
   */
  @JSONField(alternateNames = "variable_absolute_codec_string")
  private String variableAbsoluteCodecString;
  /**
   * 主叫者通道保持累计
   */
  @JSONField(alternateNames = "Caller-Channel-Hold-Accum")
  private String callerChannelHoldAccum;

  /**
   * 呼叫方通道进程时间
   */
  @JSONField(alternateNames = "Caller-Channel-Progress-Time")
  private String callerChannelProgressTime;
  /**
   * 呼叫者是否隐藏名称
   */
  @JSONField(alternateNames = "Caller-Privacy-Hide-Name")
  private String callerPrivacyHideName;
  /**
   * sip自动应答
   */
  @JSONField(alternateNames = "variable_sip_auto_answer")
  private String variableSipAutoAnswer;
  /**
   * 显示id
   */
  @JSONField(alternateNames = "variable_presence_id")
  private String variablePresenceId;
  /**
   * 呼叫者是否隐藏号码
   */
  @JSONField(alternateNames = "Caller-Privacy-Hide-Number")
  private String callerPrivacyHideNumber;
  /**
   * 广告媒体id
   */
  @JSONField(alternateNames = "variable_advertised_media_ip")
  private String variableAdvertisedMediaIp;
  /**
   * 呼叫通道桥接时间
   */
  @JSONField(alternateNames = "Caller-Channel-Bridged-Time")
  private String callerChannelBridgedTime;
  /**
   * sofia配置文件名
   */
  @JSONField(alternateNames = "variable_sofia_profile_name")
  private String variableSofiaProfileName;
  /**
   * rtp使用的编码
   */
  @JSONField(alternateNames = "variable_rtp_use_codec_string")
  private String variableRtpUseCodecString;
  /**
   * sip请求来自的ip地址
   */
  @JSONField(alternateNames = "variable_sip_from_host")
  private String variableSipFromHost;

  /**
   * 通道复活时间
   */
  @JSONField(alternateNames = "Caller-Channel-Resurrect-Time")
  private String callerChannelResurrectTime;
  /**
   * 重发号码
   */
  @JSONField(alternateNames = "variable_origination_caller_id_number")
  private String variableOriginationCallerIdNumber;
  /**
   * 视频媒体流
   */
  @JSONField(alternateNames = "variable_video_media_flow")
  private String variableVideoMediaFlow;
  /**
   *
   */
  @JSONField(alternateNames = "variable_originate_early_media")
  private String variableOriginateEarlyMedia;
  /**
   * 会话统计
   */
  @JSONField(alternateNames = "Caller-Orig-Caller-ID-Number")
  private String callerOrigCallerIdNumber;
  /**
   * 主叫号码
   */
  @JSONField(alternateNames = "variable_sip_outgoing_contact_uri")
  private String variableSipOutgoingContactUri;

  /**
   * 呼叫者id名
   */
  @JSONField(alternateNames = "variable_origination_caller_id_name")
  private String variableOriginationCallerIdName;


  /**
   * 使用检查nat
   */
  @JSONField(alternateNames = "variable_sip_nat_detected")
  private String variableSipNatDetected;
  /**
   * 是否是向外呼叫
   */
  @JSONField(alternateNames = "variable_is_outbound")
  private String variableIsOutbound;
  /**
   *
   */
  @JSONField(alternateNames = "variable_ukefu_invite_params")
  private String variableUkefuInviteParams;
  /**
   * 呼叫uuid
   */
  @JSONField(alternateNames = "Channel-Call-UUID")
  private String channelCallUuid;

  /**
   * sip请求地址
   */
  @JSONField(alternateNames = "variable_sip_req_uri")
  private String variableSipReqUri;
  @JSONField(alternateNames = "Other-Leg-Caller-ID-Name")
  private String otherLegCallerIdName;
  @JSONField(alternateNames = "Other-Leg-Unique-ID")
  private String otherLegUniqueId;
  @JSONField(alternateNames = "Other-Leg-Logical-Direction")
  private String otherLegLogicalDirection;
  @JSONField(alternateNames = "Other-Leg-Destination-Number")
  private String otherLegDestinationNumber;
  @JSONField(alternateNames = "Other-Type")
  private String otherType;
  @JSONField(alternateNames = "Other-Leg-Privacy-Hide-Name")
  private String otherLegPrivacyHideName;
  @JSONField(alternateNames = "Other-Leg-RDNIS")
  private String otherLegRDNIS;
  @JSONField(alternateNames = "Other-Leg-Profile-Created-Time")
  private String otherLegProfileCreatedTime;
  @JSONField(alternateNames = "Other-Leg-Channel-Bridged-Time")
  private String otherLegChannelBridgedTime;
  @JSONField(alternateNames = "Other-Leg-Channel-Created-Time")
  private String otherLegChannelCreatedTime;
  @JSONField(alternateNames = "Other-Leg-Channel-Transfer-Time")
  private String otherLegChannelTransferTime;
  @JSONField(alternateNames = "Other-Leg-Dialplan")
  private String otherLegDialplan;
  @JSONField(alternateNames = "Other-Leg-Network-Addr")
  private String otherLegNetworkAddr;
  @JSONField(alternateNames = "Other-Leg-Channel-Hangup-Time")
  private String otherLegChannelHangupTime;
  @JSONField(alternateNames = "Other-Leg-Caller-ID-Number")
  private String otherLegCallerIdNumber;
  @JSONField(alternateNames = "Other-Leg-Orig-Caller-ID-Name")
  private String otherLegOrigCallerIdName;
  @JSONField(alternateNames = "Other-Leg-Callee-ID-Name")
  private String otherLegCalleeIdName;
  @JSONField(alternateNames = "Other-Leg-Orig-Caller-ID-Number")
  private String otherLegOrigCallerIdNumber;
  @JSONField(alternateNames = "Other-Leg-Channel-Last-Hold")
  private String otherLegChannelLastHold;
  @JSONField(alternateNames = "Other-Leg-Privacy-Hide-Number")
  private String otherLegPrivacyHideNumber;
  @JSONField(alternateNames = "Other-Leg-Channel-Answered-Time")
  private String otherLegChannelAnswerTime;
  @JSONField(alternateNames = "Other-Leg-Source")
  private String otherLegSource;
  @JSONField(alternateNames = "Other-Leg-Channel-Name")
  private String otherLegChannelName;
  @JSONField(alternateNames = "Other-Leg-Direction")
  private String otherLegDirection;
  @JSONField(alternateNames = "Other-Leg-ANI")
  private String otherLegAni;
  @JSONField(alternateNames = "Other-Leg-Screen-Bit")
  private String otherLegScreenBit;
  @JSONField(alternateNames = "Other-Leg-Channel-Resurrect-Time")
  private String otherLegChannelResurrectTime;
  @JSONField(alternateNames = "Other-Leg-Channel-Progress-Time")
  private String otherLegChannelProgressTime;
  @JSONField(alternateNames = "Other-Leg-Context")
  private String otherLegContext;
  @JSONField(alternateNames = "Other-Leg-Channel-Hold-Accum")
  private String otherLegChannelHoldAccum;
  @JSONField(alternateNames = "Other-Leg-Callee-ID-Number")
  private String otherLegCalleeIdNumber;


}

