package com.qtxln.esl.transport.message;

/**
 * EslHeaders
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 11:30 上午
 * @since 1.0
 */
public class EslHeaders {

  /**
   * Standard ESL header names.
   * <p>
   * Note this enum will need to be kept in synch with any new headers introduced on the server side.
   * 标准ESL头名称
   * 注意这个枚举将需要与服务器端引入的任何新头保持同步
   */
  public enum Name {
    /*
     *  Minor optimization - put most often used headers at the top for fastest resolution
     *  in static fromLiteral().
     *  小优化-在static fromLiteral（）中，将最常用的头放在顶部以获得最快的解析速度
     */

    /**
     * {@code "Content-Type"}
     */
    CONTENT_TYPE("Content-Type"),
    /**
     * {@code "Content-Length"}
     */
    CONTENT_LENGTH("Content-Length"),
    /**
     * {@code "Reply-Text"}
     */
    REPLY_TEXT("Reply-Text"),
    /**
     * {@code "Job-UUID"}
     */
    JOB_UUID("Job-UUID"),
    /**
     * {@code "Socket-Mode"}
     */
    SOCKET_MODE("Socket-Mode"),
    /**
     * {@code "CONTROL"}
     */
    CONTROL("CONTROL"),
    ;

    private final String literal;

    Name(String literal) {
      this.literal = literal;
    }

    public static Name fromLiteral(String literal) {
      for (Name name : values()) {
        if (name.literal.equalsIgnoreCase(literal)) {
          return name;
        }
      }
      return null;
    }

    public String literal() {
      return literal;
    }
  }

  /**
   * 一些常见的ESL头值.这些是为了方便使用常用值而提供的.
   * 由于这些值只是字符串,因此不会将其编码为枚举以允许可能的值的很大范围.
   */
  public static final class Value {
    /**
     * {@code "+OK"}
     */
    public static final String OK = "+OK";
    /**
     * {@code "auth/request"}
     */
    public static final String AUTH_REQUEST = "auth/request";
    /**
     * {@code "api/response"}
     */
    public static final String API_RESPONSE = "api/response";
    /**
     * {@code "command/reply"}
     */
    public static final String COMMAND_REPLY = "command/reply";
    /**
     * {@code "text/event-plain"}
     */
    public static final String TEXT_EVENT_PLAIN = "text/event-plain";
    /**
     * {@code "text/event-xml"}
     */
    public static final String TEXT_EVENT_XML = "text/event-xml";
    /**
     * {@code "text/disconnect-notice"}
     */
    public static final String TEXT_DISCONNECT_NOTICE = "text/disconnect-notice";
    /**
     * {@code "-ERR invalid"}
     */
    public static final String ERR_INVALID = "-ERR invalid";

    private Value() {
    }
  }
}
