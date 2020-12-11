package com.qtxln.esl.inbound.option;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * ServerAddrOption
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:25 下午
 * @since 1.0
 */
public class ServerAddrOption {

  private static final String EMPTY_STR = "serverOptions must be not empty!";

  private final List<ServerOption> serverOptions;

  ServerAddrOption(List<ServerOption> serverOptions) {
    this.serverOptions = serverOptions;
  }

  /**
   * <p>first.</p>
   *
   * @return a {@link String} object.
   */
  public String first() {
    Validate.notEmpty(serverOptions, EMPTY_STR);
    return serverOptions.get(0).addr();
  }

  /**
   * <p>last.</p>
   *
   * @return a {@link String} object.
   */
  public String last() {
    Validate.notEmpty(serverOptions, EMPTY_STR);
    return serverOptions.get(serverOptions.size() - 1).addr();
  }

  /**
   * <p>random.</p>
   *
   * @return a {@link String} object.
   */
  public String random() {
    Validate.notEmpty(serverOptions, EMPTY_STR);
    return serverOptions.get(RandomUtils.nextInt(0, serverOptions.size())).addr();
  }

}

