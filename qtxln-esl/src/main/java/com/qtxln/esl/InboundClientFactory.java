package com.qtxln.esl;

import com.qtxln.esl.exception.InboundClientException;
import com.qtxln.esl.inbound.NettyInboundClient;
import com.qtxln.esl.inbound.option.InboundClientOption;

/**
 * InboundClientFactory 保证单例对象
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:52 下午
 * @since 1.0
 */
public class InboundClientFactory {

  private InboundClient inboundClient = null;

  private InboundClientFactory() {
  }

  static com.qtxln.esl.InboundClientFactory getInstance() {
    return InboundClientFactoryInstance.INSTANCE;
  }

  synchronized InboundClient newInboundClient(InboundClientOption option) {
    if (inboundClient == null) {
      inboundClient = new NettyInboundClient(option == null ? new InboundClientOption() : option);
      return inboundClient;
    }
    throw new InboundClientException("InboundClient has been created already, instance : [" + inboundClient + "]!");
  }

  InboundClient getInboundClient() {
    if (inboundClient == null) {
      throw new InboundClientException("InboundClient is null, you must be create it first.");
    }
    return inboundClient;
  }

  private static class InboundClientFactoryInstance {
    private static final com.qtxln.esl.InboundClientFactory INSTANCE = new com.qtxln.esl.InboundClientFactory();
  }

}

