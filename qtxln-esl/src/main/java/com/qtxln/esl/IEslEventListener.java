package com.qtxln.esl;

import com.qtxln.esl.transport.event.EslEvent;

/**
 * IEslEventListener
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:39 下午
 * @since 1.0
 */
public interface IEslEventListener {

  /**
   * Signal of a server initiated event.
   *
   * @param addr  addr
   * @param event as an {@link com.qtxln.esl.transport.event.EslEvent}
   */
  void eventReceived(String addr, EslEvent event);

  /**
   * Signal of an event containing the result of a client requested background job.  The Job-UUID will
   * be available as an event header of that name.
   *
   * @param addr  addr
   * @param event as an {@link com.qtxln.esl.transport.event.EslEvent}
   */
  void backgroundJobResultReceived(String addr, EslEvent event);


}

