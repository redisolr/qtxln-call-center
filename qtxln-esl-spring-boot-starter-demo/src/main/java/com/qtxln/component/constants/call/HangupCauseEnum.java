package com.qtxln.component.constants.call;

import lombok.Getter;
import lombok.Setter;

/**
 * 挂断原因枚举
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/23 14:20 下午
 * @since 1.0
 */
public enum HangupCauseEnum {
  /**
   * 正常（呼入或呼出时）：接通的电话进行常规的挂断电话，坐席主动挂断或用户主动挂断都可以。
   */
  NORMAL("正常"),
  /**
   * 未接通（呼出时）：外呼时由于各种原因没有接通的，例如忙、拒接、无人接听。
   */
  NOT_CONNECTED("未接通"),
  /**
   * IVR中放弃（呼入时）：当用户来电进入IVR流程，但是最终用户没有选择所需的人工服务，就挂断了电话；
   */
  IVR_GIVE_UP("IVR中放弃"),
  /**
   * 排队放弃（呼入时）：当用户按键选择了所需的人工服务，但是对应的人工服务队列坐席全忙，没有进入任何坐席的工作台，此时用户挂断了电话；
   */
  QUEUE_UP_GIVE_UP("排队放弃"),
  /**
   * 振铃放弃（呼入时）：当用户来电进入了某个坐席的工作台，并且对应坐席已经开始振铃，此时用户挂断了电话；
   */
  RING_GIVE_UP("振铃放弃"),
  /**
   * 排队超时（呼入时）：当用户按键选择了所需的人工服务，但是对应的人工服务队列坐席全忙，没有进入任何坐席的工作台，并且用户排队等待的时间超过了IVR转人工模块中设置的超时时间；
   */
  QUEUE_UP_TIMEOUT("排队超时"),
  /**
   * 坐席放弃
   */
  AGENT_GIVE_UP("坐席放弃"),

  CALL_REJECTED("用户拒绝"),
  USER_BUSY("用户忙"),
  NO_ANSWER("用户无应答"),
  NO_USER_RESPONSE("用户无响应"),
  NORMAL_TEMPORARY_FAILURE("正常临时失败"),
  TIMEOUT("超时"),
  NO_ROUTE_DESTINATION("没有渠道"),
  ORIGINATOR_CANCEL("取消呼叫"),
  NORMAL_CLEARING("正常挂断"),
  INCOMPATIBLE_DESTINATION("地址不兼容"),
  UNALLOCATED_NUMBER("未知号码"),
  LOSE_RACE("");


  @Getter
  @Setter
  private String hc;

  HangupCauseEnum(String hangupCause) {
    this.hc = hangupCause;
  }

}
