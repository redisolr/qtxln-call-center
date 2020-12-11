package com.qtxln.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 技能组基础数据
 * </p>
 *
 * @author 秦腾
 * @since 2020-09-22
 */
@Data
public class SkillGroupBasicsDataVO implements Serializable {

  private static final long serialVersionUID = -1979802413037180668L;

  /**
   * 主键
   */
  private Long id;

  /**
   * 技能组id
   */
  private Long skillGroupId;

  /**
   * 技能组名称
   */
  private String skillGroupName;

  /**
   * 总登录时长
   */
  private Long totalLoggedInTime;

  /**
   * 总未就绪时长
   */
  private Long totalBreakTime;

  /**
   * 总就绪时长
   */
  private Long totalReadyTime;

  /**
   * 最大就绪时长
   */
  private Long maxReadyTime;

  /**
   * 平均就绪时长
   */
  private BigDecimal averageReadyTime;

  /**
   * 总振铃时长
   */
  private Long totalRingTime;

  /**
   * 总电话接待量
   */
  private Long totalCalls;

  /**
   * 总通话时长
   */
  private Long totalTalkTime;

  /**
   * 最大通话时长
   */
  private Long maxTalkTime;

  /**
   * 平均通话时长
   */
  private BigDecimal averageTalkTime;

  @ApiModelProperty("页码")
  @NotNull(message = "页码不能为空", groups = {GroupQuery.class})
  private Integer pageNum;

  @ApiModelProperty("查询长度")
  @NotNull(message = "查询长度不能为空", groups = {GroupQuery.class})
  private Integer pageSize;

  public interface GroupQuery {
  }

}
