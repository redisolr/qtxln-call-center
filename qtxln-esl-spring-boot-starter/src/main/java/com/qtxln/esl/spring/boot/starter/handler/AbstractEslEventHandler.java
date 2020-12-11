package com.qtxln.esl.spring.boot.starter.handler;

import com.qtxln.esl.InboundClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractEslEventHandler
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 16:00 下午
 * @since 1.0
 */
public abstract class AbstractEslEventHandler implements EslEventHandler {

  @Autowired
  protected InboundClient inboundClient;

  protected final Logger log = LoggerFactory.getLogger(getClass());

}

