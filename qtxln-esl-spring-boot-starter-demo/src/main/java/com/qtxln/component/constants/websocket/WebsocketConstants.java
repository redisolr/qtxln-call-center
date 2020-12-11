package com.qtxln.component.constants.websocket;

import javax.websocket.Session;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * websocket常量类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/7/2 22:21 下午
 * @since 1.0
 */
public class WebsocketConstants {

  private WebsocketConstants() {
  }

  /**
   * 当前连接信息存储,虽然@Component默认是单例的,
   * 但SpringBoot还是会为每个websocket连接初始化一个bean,
   * 所以可以用一个静态set保存起来,这里保存的是这个bean的Session,方便操作.
   */
  public static final Set<Session> WEB_SOCKET_SET = new CopyOnWriteArraySet<>();

}
