package com.qtxln.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author 秦腾
 * @version 1.0
 * @date 2020-10-16 16:33
 * @since 1.0
 */
@Data
public class AgentStateRecordVO {

  /**
   * 主键
   */
  private Long id;

  /**
   * 坐席id
   */
  private Long agentId;

  /**
   * 坐席名称
   */
  private String agentName;

  /**
   * 坐席状态
   */
  private String agentState;

  /**
   * 持续时间(单位:秒)
   */
  private Long duration;


  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  @ApiModelProperty("页码")
  @NotNull(message = "页码不能为空", groups = {GroupQuery.class})
  private Integer pageNum;

  @ApiModelProperty("查询长度")
  @NotNull(message = "查询长度不能为空", groups = {GroupQuery.class})
  private Integer pageSize;

  public interface GroupQuery {
  }

}
