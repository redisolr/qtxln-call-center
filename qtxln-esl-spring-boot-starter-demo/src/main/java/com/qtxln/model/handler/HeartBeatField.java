package com.qtxln.model.handler;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * HeartBeatField
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/21 14:16 下午
 * @since 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HeartBeatField extends CommonField {

  /**
   * 会话统计
   */
  @JSONField(alternateNames = "Session-Count")
  private String sessionCount;
  /**
   * 最大会话数
   */
  @JSONField(alternateNames = "Max-Sessions")
  private String maxSessions;
  /**
   * 会话最大峰值
   */
  @JSONField(alternateNames = "Session-Peak-Max")
  private String sessionPeakMax;
  /**
   * 正常运行时间
   */
  @JSONField(alternateNames = "Up-Time")
  private String upTime;
  /**
   * 正常运行时间 毫秒
   */
  @JSONField(alternateNames = "Uptime-msec")
  private String uptimeMsec;
  /**
   * 每秒最大会话数
   */
  @JSONField(alternateNames = "Session-Per-Sec-Max")
  private String sessionPerSecMax;
  /**
   * 每秒会话数
   */
  @JSONField(alternateNames = "Session-Per-Sec")
  private String sessionPerSec;
  /**
   * 事件信息
   */
  @JSONField(alternateNames = "Event-Info")
  private String eventInfo;
  /**
   * FreeSWITCH版本
   */
  @JSONField(alternateNames = "FreeSWITCH-Version")
  private String freeSwitchVersion;
  /**
   * 上次每秒会话数
   */
  @JSONField(alternateNames = "Session-Per-Sec-Last")
  private String sessionPerSecLast;
  /**
   * 最近5分钟会话
   */
  @JSONField(alternateNames = "Session-Peak-FiveMin")
  private String sessionPeakFiveMin;
  /**
   * 5分钟每秒会话
   */
  @JSONField(alternateNames = "Session-Per-Sec-FiveMin")
  private String sessionPerSecFiveMin;
  /**
   * 空闲CPU
   */
  @JSONField(alternateNames = "Idle-CPU")
  private String idleCpu;
  /**
   * fs启动后到现在处理的会话
   */
  @JSONField(alternateNames = "Session-Since-Startup")
  private String sessionSinceStartup;
  /**
   * 使用CPU
   */
  private BigDecimal useCpu;

}

