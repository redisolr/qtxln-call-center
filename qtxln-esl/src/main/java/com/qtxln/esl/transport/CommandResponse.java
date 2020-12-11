package com.qtxln.esl.transport;

import com.qtxln.esl.transport.message.EslHeaders;
import com.qtxln.esl.transport.message.EslMessage;

/**
 * CommandResponse
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:50 下午
 * @since 1.0
 */
public class CommandResponse {

  private final String command;
  private final String replyText;
  private final EslMessage response;
  private final boolean success;

  /**
   * <p>Constructor for CommandResponse.</p>
   *
   * @param command  a {@link String} object.
   * @param response a {@link com.qtxln.esl.transport.message.EslMessage} object.
   */
  public CommandResponse(String command, EslMessage response) {
    this.command = command;
    this.response = response;
    this.replyText = response == null ? "" : response.getHeaderValue(EslHeaders.Name.REPLY_TEXT);
    this.success = replyText.startsWith("+OK");
  }

  /**
   * <p>Getter for the field <code>command</code>.</p>
   *
   * @return the original command sent to the server
   */
  public String getCommand() {
    return command;
  }

  /**
   * <p>isOk.</p>
   *
   * @return true if and only if the response Reply-Text line starts with "+OK"
   */
  public boolean isOk() {
    return success;
  }

  /**
   * <p>Getter for the field <code>replyText</code>.</p>
   *
   * @return the full response Reply-Text line.
   */
  public String getReplyText() {
    return replyText;
  }

  /**
   * <p>Getter for the field <code>response</code>.</p>
   *
   * @return {@link com.qtxln.esl.transport.message.EslMessage} the full response from the server
   */
  public EslMessage getResponse() {
    return response;
  }

}

