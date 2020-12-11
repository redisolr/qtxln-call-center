package com.qtxln.model.esl;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 分机注册信息
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 16:32 下午
 * @since 1.0
 */
@Data
public class Registration {

  @JSONField(alternateNames = "call-id")
  private String callId;
  @JSONField(alternateNames = "user")
  private String user;
  @JSONField(alternateNames = "contact")
  private String contact;
  @JSONField(alternateNames = "agent")
  private String agent;
  @JSONField(alternateNames = "status")
  private String status;
  @JSONField(alternateNames = "ping-status")
  private String host;
  @JSONField(alternateNames = "ping-time")
  private String pingStatus;
  @JSONField(alternateNames = "host")
  private String pingTime;
  @JSONField(alternateNames = "network-ip")
  private String networkIp;
  @JSONField(alternateNames = "network-port")
  private String networkPort;
  @JSONField(alternateNames = "sip-auth-user")
  private String sipAuthUser;
  @JSONField(alternateNames = "sip-auth-realm")
  private String sipAuthRealm;
  @JSONField(alternateNames = "mwi-account")
  private String mwiAccount;
  @JSONField(alternateNames = "name")
  private String ipAddr;

}

