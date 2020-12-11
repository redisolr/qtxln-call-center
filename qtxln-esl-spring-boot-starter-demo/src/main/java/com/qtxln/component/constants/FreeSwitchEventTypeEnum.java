package com.qtxln.component.constants;

/**
 * FreeSwitchEventTypeEnum fs事件类型枚举
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/21 14:52 下午
 * @since 1.0
 */
public enum FreeSwitchEventTypeEnum {
  /**
   * 心跳
   */
  HEARTBEAT,
  // 跟呼叫相关的通道事件
  /**
   * 通道创建事件
   */
  CHANNEL_CREATE,
  /**
   * 通道应答事件
   */
  CHANNEL_ANSWER,
  /**
   * 通道桥接事件
   */
  CHANNEL_BRIDGE,
  /**
   * 通道挂断事件
   */
  CHANNEL_HANGUP,
  /**
   * 录音开始时间
   */
  RECORD_START,
  /**
   * 录音结束时间
   */
  RECORD_STOP,
  /**
   * 通道挂机完毕
   */
  CHANNEL_HANGUP_COMPLETE,
  /**
   * 通道保持
   */
  CHANNEL_HOLD(),
  /**
   * 通道取消保持
   */
  CHANNEL_UNHOLD,
  /**
   * 坐席更新
   */
  CC_AGENT_UPDATE,
  /**
   * 自定义事件(全部事件)
   */
  CUSTOM,
  /**
   * 双音多频
   */
  DTMF,
  /**
   * 后台任务
   */
  BACKGROUND_JOB,
  /**
   * 通道销毁
   */
  CHANNEL_DESTROY,
  /**
   * 通道起源
   */
  CHANNEL_ORIGINATE,
  /**
   * 通道输出
   */
  CHANNEL_OUTGOING,
  /**
   * 计费心跳包心跳包
   */
  SESSION_HEARTBEAT


}

