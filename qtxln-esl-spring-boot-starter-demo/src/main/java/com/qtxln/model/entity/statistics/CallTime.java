package com.qtxln.model.entity.statistics;

import lombok.Data;

/**
 * 通话时间
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/9/1 9:02 上午
 * @since 1.0
 */
@Data
public class CallTime {

  /**
   * 总时长
   */
  private Long totalTime;
  /**
   * 通话时长
   */
  private Long talkTime;

}
