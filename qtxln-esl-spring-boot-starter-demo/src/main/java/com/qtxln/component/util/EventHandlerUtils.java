package com.qtxln.component.util;

import java.util.Map;

/**
 * 事件handler工具类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-09 10:14
 * @since 1.0
 */
public class EventHandlerUtils {

  private EventHandlerUtils() {}

  public static void filterData(Map<String, String> map) {
    map.remove("","");
    map.remove("variable_rtp_local_sdp_str");
    map.remove("variable_switch_r_sdp");
    map.remove("variable_switch_m_sdp");
    map.remove("Core-UUID");
    map.remove("variable_sip_allow");
    map.remove("FreeSWITCH-Hostname");
    map.remove("FreeSWITCH-IPv6");
    map.remove("FreeSWITCH-IPv4");
  }

}
