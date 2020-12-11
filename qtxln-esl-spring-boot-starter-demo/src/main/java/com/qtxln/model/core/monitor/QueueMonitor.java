package com.qtxln.model.core.monitor;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 19:26
 * @since 1.0
 */
@Data
public class QueueMonitor {

  /**
   * 未就绪
   */
  @JSONField(alternateNames = "not_ready")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer noReadyCount = 0;
  /**
   * 就绪
   */
  @JSONField(alternateNames = "ready")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer readyCount = 0;
  /**
   * 振铃
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JSONField(alternateNames = "ringing")
  private Integer ringCount = 0;
  /**
   * 通话中
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JSONField(alternateNames = "in_call")
  private Integer callInCount = 0;

}
