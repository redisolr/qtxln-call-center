package com.qtxln.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 录音信息表
 * </p>
 *
 * @author 秦腾
 * @since 2020-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordingInformation implements Serializable {

  private static final long serialVersionUID = 2356931635510881832L;

  /**
   * 主键
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 通话的唯一标识
   */
  private String uniqueId;

  /**
   * 类型(1VIR.2智能语音.3振铃4.人工服务.5满意度)
   */
  private Integer type;

  /**
   * 号码
   */
  private String number;

  /**
   * 时长(毫秒)
   */
  private Long duration;


}
