package com.qtxln.model.handler;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Custom
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-15 13:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Custom extends CommonField {

  @JSONField(alternateNames = "CC-Agent")
  private String ccAgent;

  @JSONField(alternateNames = "CC-Action")
  private String ccAction;

  @JSONField(alternateNames = "CC-Agent-Status")
  private String ccAgentStatus;

  @JSONField(alternateNames = "CC-Agent-State")
  private String ccAgentState;

  @JSONField(alternateNames = "Event-Subclass")
  private String eventSubclass;

  @JSONField(alternateNames = "CC-Queue")
  private String ccQueue;

  @JSONField(alternateNames = "CC-Count")
  private String ccCount;

}
