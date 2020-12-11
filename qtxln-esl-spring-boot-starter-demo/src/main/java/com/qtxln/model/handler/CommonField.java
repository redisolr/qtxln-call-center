package com.qtxln.model.handler;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * CommonField
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/21 11:00 上午
 * @since 1.0
 */
@Data
public class CommonField {

  /**
   * FreeSWITCH实例的唯一ID,每次重启时都会更改
   */
  @JSONField(alternateNames = "Core-UUID")
  private String coreUuid;
  /**
   * 触发此事件的源文件
   */
  @JSONField(alternateNames = "Event-Calling-File")
  private String eventCallingFile;
  /**
   * 触发此事件的源函数
   */
  @JSONField(alternateNames = "Event-Calling-Function")
  private String eventCallingFunction;
  /**
   * 触发此事件的源文件行
   */
  @JSONField(alternateNames = "Event-Calling-Line-Number")
  private String eventCallingLineNumber;
  /**
   * 日期/时间，包括触发事件时来自FreeSWITCH实例的时区。
   */
  @JSONField(alternateNames = "Event-Date-GMT")
  private String eventDateGmt;
  /**
   * FreeSWITCH实例在事件触发时的本地日期/时间
   */
  @JSONField(alternateNames = "Event-Date-Local")
  private String eventDateLocal;
  /**
   * FreeSWITCH实例在事件触发时的Unix纪元时间.(以微秒为单位，除以1000得到毫秒)
   */
  @JSONField(alternateNames = "Event-Date-Timestamp")
  private String eventDateTimestamp;
  /**
   * 事件名
   */
  @JSONField(alternateNames = "Event-Name")
  private String eventName;
  /**
   * FreeSWITCH实例上事件的顺序ID.
   * 每次重新启动后,此值重置为零,并且并非每个实例都唯一.
   */
  @JSONField(alternateNames = "Event-Sequence")
  private String eventSequence;
  /**
   * FreeSWITCH实例的IPv4地址
   */
  @JSONField(alternateNames = "FreeSWITCH-IPv4")
  private String freeSwitchIpv4;
  /**
   * FreeSWITCH实例的IPv6地址
   */
  @JSONField(alternateNames = "FreeSWITCH-IPv6")
  private String freeSwitchIpv6;
  /**
   * 运行FreeSWITCH实例的计算机的主机名
   */
  @JSONField(alternateNames = "FreeSWITCH-Hostname")
  private String freeSwitchHostName;
  /**
   * FreeSWITCH实例的名称,通常与FreeSWITCH-Hostname相同,除非具有复杂的配置(例如:故障转移,多宿主等)
   */
  @JSONField(alternateNames = "FreeSWITCH-Switchname")
  private String freeSwitchSwitchName;

}

