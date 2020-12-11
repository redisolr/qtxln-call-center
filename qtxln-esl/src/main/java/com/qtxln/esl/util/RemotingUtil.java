
package com.qtxln.esl.util;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * HeaderParser
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 13:52 下午
 * @since 1.0
 */
public class RemotingUtil {

  private RemotingUtil() {
  }

  /**
   * <p>socketAddress2String.</p>
   *
   * @param addr a {@link SocketAddress} object.
   * @return a {@link String} object.
   */
  public static String socketAddress2String(final SocketAddress addr) {
    InetSocketAddress inetSocketAddress = (InetSocketAddress) addr;
    return inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort();
  }
}
