package com.qtxln.model.handler;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * FsEvent 事件 实体类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 14:43
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FsEvent extends CommonChannel{

  @JSONField(alternateNames = "variable_sip_network_ip")
  private String variableSipNetworkIp;

  @JSONField(alternateNames = "variable_sip_allow")
  private String variableSipAllow;

  @JSONField(alternateNames = "variable_rtp_use_ssrc")
  private String variableRtpUseSsrc;

  @JSONField(alternateNames = "variable_start_stamp")
  private String variableStartStamp;

  /**
   * 呼叫方通道进程媒体时间   0
   */
  @JSONField(alternateNames = "Caller-Channel-Progress-Media-Time")
  private String callerChannelProgressMediaTime;

  @JSONField(alternateNames = "Caller-Dialplan")
  private String callerDialplan;

  @JSONField(alternateNames = "variable_rtp_audio_in_flaw_total")
  private String variableRtpAudioInFlawTotal;

  @JSONField(alternateNames = "variable_sip_cseq")
  private String variableSipCseq;

  @JSONField(alternateNames = "variable_rtp_auto_adjust_audio")
  private String variableRtpAutoAdjustAudio;

  /**
   * 通道状态号
   */
  @JSONField(alternateNames = "Channel-State-Number")
  private String channelStateNumber;

  @JSONField(alternateNames = "variable_uuid")
  private String variableUuid;

  /**
   * uuid
   */
  @JSONField(alternateNames = "variable_remote_media_ip")
  private String variableRemoteMediaIp;

  /**
   * 挂断原因
   */
  @JSONField(alternateNames = "Hangup-Cause")
  private String hangupCause;

  /**
   * 呼叫uuid
   */
  @JSONField(alternateNames = "variable_call_uuid")
  private String variableCallUuid;

  /**
   * 主叫配置文件创建时间
   */
  @JSONField(alternateNames = "Caller-Profile-Created-Time")
  private String callerProfileCreateTime;


  @JSONField(alternateNames = "variable_rtp_use_pt")
  private String variableRtpUsePt;

  /**
   * 呼叫者屏蔽位
   */
  @JSONField(alternateNames = "Caller-Screen-Bit")
  private String callerScreenBit;

  @JSONField(alternateNames = "variable_answer_stamp")
  private String variableAnswerStamp;

  /**
   * 呼叫者逻辑方向
   */
  @JSONField(alternateNames = "Caller-Logical-Direction")
  private String callerLogicalDirection;

  @JSONField(alternateNames = "variable_hangup_after_bridge")
  private String variableHangupAfterBridge;

  @JSONField(alternateNames = "variable_write_rate")
  private String variableWriteRate;

  @JSONField(alternateNames = "variable_rtp_audio_in_jitter_burst_rate")
  private String variableRtpAudioInJitterBurstRate;

  @JSONField(alternateNames = "variable_rtp_audio_in_jitter_max_variance")
  private String variableRtpAudioInJitterMaxVariance;

  /**
   * 呼叫方通道进程时间
   */
  @JSONField(alternateNames = "Caller-Channel-Progress-Time")
  private String callerChannelProgressTime;

  @JSONField(alternateNames = "variable_sip_from_tag")
  private String variableSipFromTag;

  @JSONField(alternateNames = "variable_remote_audio_ip_reported")
  private String variableRemoteAudioIpReported;

  @JSONField(alternateNames = "variable_sip_from_user_stripped")
  private String variableSipFromUserStripped;

  @JSONField(alternateNames = "variable_rtp_audio_in_mos")
  private String variableRtpAudioInMos;

  @JSONField(alternateNames = "variable_last_arg")
  private String variableLastArg;

  /**
   * sofia配置文件名
   */
  @JSONField(alternateNames = "variable_sofia_profile_name")
  private String variableSofiaProfileName;

  @JSONField(alternateNames = "variable_sip_via_host")
  private String variableSipViaHost;

  @JSONField(alternateNames = "variable_sip_from_port")
  private String variableSipFromPort;

  @JSONField(alternateNames = "variable_bridge_epoch")
  private String variableBridgeEpoch;

  @JSONField(alternateNames = "variable_hold_accum_seconds")
  private String variableHoldAccumSeconds;

  @JSONField(alternateNames = "variable_sip_contact_uri")
  private String variableSipContactUri;

  @JSONField(alternateNames = "variable_rtp_audio_out_media_bytes")
  private String variableRtpAudioOutMediaBytes;

  @JSONField(alternateNames = "variable_rtp_audio_in_largest_jb_size")
  private String variableRtpAudioInLargestJbSize;

  @JSONField(alternateNames = "variable_progress_uepoch")
  private String variableProgressUepoch;

  @JSONField(alternateNames = "Caller-Network-Addr")
  private String callerNetworkAddr;

  @JSONField(alternateNames = "variable_sip_contact_port")
  private String variableSipContactPort;

  @JSONField(alternateNames = "variable_rtp_use_codec_name")
  private String variableRtpUseCodecName;

  @JSONField(alternateNames = "variable_progressmsec")
  private String variableProgressmsec;

  @JSONField(alternateNames = "variable_DP_MATCH")
  private String variableDpMatch;

  @JSONField(alternateNames = "variable_sip_user_agent")
  private String variableSipUserAgent;

  @JSONField(alternateNames = "variable_cc_agent")
  private String variableCcAgent;

  @JSONField(alternateNames = "variable_answer_uepoch")
  private String variableAnswerUepoch;

  @JSONField(alternateNames = "variable_sip_contact_host")
  private String variableSipContactHost;

  @JSONField(alternateNames = "Caller-Username")
  private String callerUsername;

  @JSONField(alternateNames = "variable_sip_acl_authed_by")
  private String variableSipAclAuthedBy;

  @JSONField(alternateNames = "variable_rtp_audio_rtcp_packet_count")
  private String variableRtpAudioRtcpPacketCount;

  @JSONField(alternateNames = "variable_ringback")
  private String variableRingBack;

  @JSONField(alternateNames = "variable_cc_queue_canceled_epoch")
  private String variableCcQueueCanceledEpoch;

  @JSONField(alternateNames = "variable_waitusec")
  private String variableWaitusec;


  @JSONField(alternateNames = "variable_sip_term_status")
  private String variableSipTermStatus;

  @JSONField(alternateNames = "variable_profile_start_stamp")
  private String variableProfileStartStamp;

  @JSONField(alternateNames = "variable_profile_start_epoch")
  private String variableProfileStartEpoch;

  @JSONField(alternateNames = "variable_billmsec")
  private String variableBillmsec;

  @JSONField(alternateNames = "variable_write_codec")
  private String variableWriteCodec;

  @JSONField(alternateNames = "variable_start_epoch")
  private String variableStartEpoch;

  @JSONField(alternateNames = "variable_rtp_audio_in_raw_bytes")
  private String variableRtpAudioInRawBytes;

  @JSONField(alternateNames = "variable_ep_codec_string")
  private String variableEpCodecString;

  @JSONField(alternateNames = "variable_cc_queue_joined_epoch")
  private String variableCcQueueJoinedEpoch;

  /**
   * sip发送的主机    t-12368hotline.aegis-info.com
   */
  @JSONField(alternateNames = "variable_sip_to_host")
  private String variableSipToHost;

  @JSONField(alternateNames = "variable_remote_media_port")
  private String variableRemoteMediaPort;

  @JSONField(alternateNames = "variable_sip_hangup_disposition")
  private String variableSipHangupDisposition;

  @JSONField(alternateNames = "Channel-Read-Codec-Name")
  private String channelReadCodecName;

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

  @JSONField(alternateNames = "variable_playback_seconds")
  private String variablePlaybackSeconds;

  @JSONField(alternateNames = "variable_flow_billmsec")
  private String variableFlowBillmsec;

  @JSONField(alternateNames = "variable_limit_usage_inbound_1101")
  private String variableLimitUsageInbound1101;

  @JSONField(alternateNames = "variable_rtp_audio_rtcp_octet_count")
  private String variableRtpAudioRtcpOctetCount;

  @JSONField(alternateNames = "variable_start_uepoch")
  private String variableStartUepoch;

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

  @JSONField(alternateNames = "variable_sip_req_user")
  private String variableSipReqUser;

  @JSONField(alternateNames = "variable_end_epoch")
  private String variableEndEpoch;

  @JSONField(alternateNames = "variable_last_app")
  private String variableLastApp;

  @JSONField(alternateNames = "variable_sip_to_user")
  private String variableSipToUser;

  @JSONField(alternateNames = "variable_digits_dialed")
  private String variableDigitsDialed;

  @JSONField(alternateNames = "variable_cc_side")
  private String variableCcSide;

  @JSONField(alternateNames = "variable_sip_full_to")
  private String variableSipFullTo;

  /**
   * 恢复配置文件名
   */
  @JSONField(alternateNames = "variable_recovery_profile_name")
  private String variableRecoveryProfileName;

  @JSONField(alternateNames = "Channel-Write-Codec-Rate")
  private String channelWriteCodecRate;

  @JSONField(alternateNames = "variable_limit_rate_inbound_1101")
  private String variableLimitRateInbound1101;

  @JSONField(alternateNames = "variable_rtp_last_audio_codec_string")
  private String variableRtpLastAudioCodecString;

  /**
   * 方向
   */
  @JSONField(alternateNames = "variable_direction")
  private String variableDirection;

  @JSONField(alternateNames = "variable_rtp_use_codec_channels")
  private String variableRtpUseCodecChannels;

  @JSONField(alternateNames = "variable_sip_network_port")
  private String variableSipNetworkPort;

  @JSONField(alternateNames = "variable_sip_contact_user")
  private String variableSipContactUser;

  @JSONField(alternateNames = "variable_sip_req_host")
  private String variableSipReqHost;

  @JSONField(alternateNames = "variable_rtp_use_codec_rate")
  private String variableRtpUseCodecRate;

  @JSONField(alternateNames = "variable_rtp_audio_in_media_bytes")
  private String variableRtpAudioInMediaBytes;

  @JSONField(alternateNames = "variable_cc_queue")
  private String variableCcQueue;

  /**
   * 通道名
   */
  @JSONField(alternateNames = "variable_channel_name")
  private String variableChannelName;

  @JSONField(alternateNames = "variable_uduration")
  private String variableUduration;

  @JSONField(alternateNames = "variable_rtp_audio_out_raw_bytes")
  private String variableRtpAudioOutRawBytes;

  @JSONField(alternateNames = "variable_limit_rate")
  private String variableLimitRate;

  /**
   * 显示id
   */
  @JSONField(alternateNames = "variable_presence_id")
  private String variablePresenceId;

  @JSONField(alternateNames = "variable_rtp_audio_out_packet_count")
  private String variableRtpAudioOutPacketCount;

  @JSONField(alternateNames = "variable_sip_authorized")
  private String variableSipAuthorized;

  /**
   * 广告媒体id
   */
  @JSONField(alternateNames = "variable_advertised_media_ip")
  private String variableAdvertisedMediaIp;

  @JSONField(alternateNames = "variable_rtp_audio_in_jitter_packet_count")
  private String variableRtpAudioInJitterPacketCount;

  @JSONField(alternateNames = "variable_end_stamp")
  private String variableEndStamp;

  @JSONField(alternateNames = "variable_last_hold_uepoch")
  private String variableLastHoldUepoch;

  @JSONField(alternateNames = "variable_sip_via_rport")
  private String variableSipViaRport;

  @JSONField(alternateNames = "variable_flow_billsec")
  private String variableFlowBillsec;

  @JSONField(alternateNames = "Caller-Channel-Resurrect-Time")
  private String callerChannelResurrectTime;

  @JSONField(alternateNames = "variable_progress_mediausec")
  private String variableProgressMediausec;

  @JSONField(alternateNames = "variable_cc_member_uuid")
  private String variableCcMemberUuid;

  @JSONField(alternateNames = "variable_cc_member_session_uuid")
  private String variableCcMemberSessionUuid;

  /**
   * 会话统计
   */
  @JSONField(alternateNames = "Caller-Orig-Caller-ID-Number")
  private String callerOrigCallerIdNumber;

  /**
   * 主叫通道传输时间
   */
  @JSONField(alternateNames = "Caller-Channel-Transfer-Time")
  private String callerChannelTransferTime;

  /**
   * 通道创建时间
   */
  @JSONField(alternateNames = "Caller-Channel-Created-Time")
  private String callerChannelCreatedTime;

  @JSONField(alternateNames = "Event-Date-Timestamp")
  private String eventDateTimestamp;

  /**
   * 呼叫方向   outbound
   */
  @JSONField(alternateNames = "Presence-Call-Direction")
  private String presenceCallDirection;

  /**
   * 唯一id
   */
  @JSONField(alternateNames = "Unique-ID")
  private String uniqueId;

  /**
   * 呼叫状态
   */
  @JSONField(alternateNames = "Channel-Call-State")
  private String channelCallState;

  @JSONField(alternateNames = "Event-Calling-File")
  private String eventCallingFile;

  @JSONField(alternateNames = "Channel-Write-Codec-Bit-Rate")
  private String channelWriteCodecBitRate;

  /**
   * 主叫者通道保持累计
   */
  @JSONField(alternateNames = "Caller-Channel-Hold-Accum")
  private String callerChannelHoldAccum;

  /**
   * 呼叫者是否隐藏号码
   */
  @JSONField(alternateNames = "Caller-Privacy-Hide-Number")
  private String callerPrivacyHideNumber;

  /**
   * 呼叫通道桥接时间
   */
  @JSONField(alternateNames = "Caller-Channel-Bridged-Time")
  private String callerChannelBridgedTime;

  /**
   * 呼叫者来源
   */
  @JSONField(alternateNames = "Caller-Source")
  private String callerSource;

  /**
   * 主叫号码
   */
  @JSONField(alternateNames = "Caller-ANI")
  private String callerAni;

  /**
   * 通道挂机时间
   */
  @JSONField(alternateNames = "Caller-Channel-Hangup-Time")
  private String callerChannelHangupTime;

  @JSONField(alternateNames = "Channel-Read-Codec-Bit-Rate")
  private String channelReadCodecBitRate;

  @JSONField(alternateNames = "Event-Calling-Function")
  private String eventCallingFunction;

  /**
   * 配置文件索引
   */
  @JSONField(alternateNames = "Caller-Profile-Index")
  private String callerProfileIndex;

  /**
   * 呼叫uuid
   */
  @JSONField(alternateNames = "Channel-Call-UUID")
  private String channelCallUuid;

  /**
   * 主叫context
   */
  @JSONField(alternateNames = "Caller-Context")
  private String callerContext;

  @JSONField(alternateNames = "Event-Calling-Line-Number")
  private String eventCallingLineNumber;

  /**
   * 会叫方向   outbound
   */
  @JSONField(alternateNames = "Caller-Direction")
  private String callerDirection;

  /**
   * 呼叫者id名
   */
  @JSONField(alternateNames = "Caller-Orig-Caller-ID-Name")
  private String callerOrigCallerIdName;

  /**
   * 呼叫者是否隐藏名称
   */
  @JSONField(alternateNames = "Caller-Privacy-Hide-Name")
  private String callerPrivacyHideName;

  @JSONField(alternateNames = "Event-Date-GMT")
  private String eventDateGMT;

  @JSONField(alternateNames = "Event-Sequence")
  private String eventSequence;

  /**
   * 本地媒体端口  19024
   */
  @JSONField(alternateNames = "variable_local_media_port")
  private String variableLocalMediaPort;

  /**
   * sip请求参数   intercom=true
   */
  @JSONField(alternateNames = "variable_sip_invite_params")
  private String variableSipInviteParams;


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
   * 呼叫者被呼叫者id名称
   */
  @JSONField(alternateNames = "Caller-Callee-ID-Name")
  private String callerCalleeIdName;

  /**
   * sip网络地址
   */
  @JSONField(alternateNames = "variable_sip_local_network_addr")
  private String variableSipLocalNetworkAddr;

  /**
   * 拨号用户
   */
  @JSONField(alternateNames = "variable_dialed_user")
  private String variableDialedUser;

  /**
   * sip 邀请域
   */
  @JSONField(alternateNames = "variable_sip_invite_domain")
  private String variableSipInviteDomain;

  /**
   * 媒体webrtc
   */
  @JSONField(alternateNames = "variable_media_webrtc")
  private String variableMediaWebRtc;

  /**
   * 拨号域
   */
  @JSONField(alternateNames = "variable_dialed_domain")
  private String variableDialedDomain;

  /**
   * sip配置文件名
   */
  @JSONField(alternateNames = "variable_sip_profile_name")
  private String variableSipProfileName;

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
   * sip自动应答
   */
  @JSONField(alternateNames = "variable_sip_auto_answer")
  private String variableSipAutoAnswer;

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
   * 重发号码
   */
  @JSONField(alternateNames = "variable_origination_caller_id_number")
  private String variableOriginationCallerIdNumber;
  /**
   * 视频媒体流
   */
  @JSONField(alternateNames = "variable_video_media_flow")
  private String variableVideoMediaFlow;

  @JSONField(alternateNames = "variable_originate_early_media")
  private String variableOriginateEarlyMedia;

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

  @JSONField(alternateNames = "variable_effective_caller_id_number")
  private String variableEffectiveCallerIdNumber;

  /**
   * 通话时长,从Channel创建开始
   */
  @JSONField(alternateNames = "variable_duration")
  private Long variableDuration;

  /**
   * 计费时长,从应答后开始计时
   */
  @JSONField(alternateNames = "variable_billsec")
  private Long variableBillSec;

  @JSONField(alternateNames = "DTMF-Digit")
  private String dtmfDigit;

}
