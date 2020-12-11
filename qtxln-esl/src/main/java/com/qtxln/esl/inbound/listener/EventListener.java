package com.qtxln.esl.inbound.listener;

import java.util.List;

/**
 * EventListener
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:17 下午
 * @since 1.0
 */
public interface EventListener {

  /**
   * <p>addEvents.</p>
   *
   * @param list a {@link List} object.
   */
  void addEvents(List<String> list);

  /**
   * <p>cancelEvents.</p>
   */
  void cancelEvents();

}

