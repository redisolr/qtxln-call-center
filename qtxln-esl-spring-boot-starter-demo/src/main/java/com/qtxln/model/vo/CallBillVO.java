package com.qtxln.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 话单VO
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/21 15:34 下午
 * @since 1.0
 */
@Data
public class CallBillVO {

  @ApiModelProperty("id")
  private Long id;
  @ApiModelProperty("主叫号码")
  private String callerNumber;
  @ApiModelProperty("被叫号码")
  private String calledNumber;
  @ApiModelProperty("呼叫类型")
  private String callType;
  @ApiModelProperty("拨打时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime callTime;
  @ApiModelProperty("挂断原因")
  private String hangupCause;
  @ApiModelProperty("挂断原因含义")
  private String hangupCauseStr;
  @ApiModelProperty("总时长")
  private Integer totalTime;
  @ApiModelProperty("通话时长")
  private Integer talkTime;
  @ApiModelProperty("满意度")
  private String satisfaction;
  @ApiModelProperty("坐席")
  private String agent;
  @ApiModelProperty("技能组")
  private String skillGroup;

  @ApiModelProperty("页码")
  @NotNull(message = "页码不能为空", groups = {GroupQuery.class})
  private Integer pageNum;

  @ApiModelProperty("查询长度")
  @NotNull(message = "查询长度不能为空", groups = {GroupQuery.class})
  private Integer pageSize;

  public interface GroupQuery {
  }

}
