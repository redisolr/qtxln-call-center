package com.qtxln.esl.inbound.listener;

import com.qtxln.esl.inbound.option.ServerOption;

/**
 * ServerOptionListener
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:22 下午
 * @since 1.0
 */
public interface ServerOptionListener {

  /**
   * <p>onAdded.</p>
   *
   * @param serverOption a {@link com.qtxln.esl.inbound.option.ServerOption} object.
   */
  void onAdded(ServerOption serverOption);

  /**
   * <p>onRemoved.</p>
   *
   * @param serverOption a {@link com.qtxln.esl.inbound.option.ServerOption} object.
   */
  void onRemoved(ServerOption serverOption);


}

