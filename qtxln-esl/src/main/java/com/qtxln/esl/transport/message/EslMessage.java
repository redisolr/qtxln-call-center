package com.qtxln.esl.transport.message;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Basic FreeSWITCH Event Socket messages from the server are decoded into this data object.
 * <p>
 * An ESL message is modelled as text lines.  A message always has one or more header lines, and
 * optionally may have some body lines.
 * ESL消息被建模为文本行.一个消息总是包含一个或者多个标题行,也可以有一些正文行.
 * <p>
 * Header lines are parsed and cached in a map keyed by the {@link EslHeaders.Name} enum.  A message
 * is always expected to have a "Content-Type" header
 * 标题行被解析并缓存在 EslHeaders.Name 枚举中, 一个消息必包含一个 "Content-Type" header
 * <p>
 * Any Body lines are cached in a list.
 * 任何正文行都缓存在列表中
 * @author qinteng
 * @version 1.0
 * @date 2020/5/11 11:26 上午
 * @since 1.0
 */
@Slf4j
public class EslMessage {

  private final Map<EslHeaders.Name, String> headers = new EnumMap<>(EslHeaders.Name.class);
  private final List<String> body = new ArrayList<>();
  private Integer contentLength = null;

  /**
   * All the received message headers in a map keyed by {@link EslHeaders.Name}. The string mapped value
   * is the parsed content of the header line (ie, it does not include the header name).
   * 所有收到的消息头 在一个map中 map的key 是 EslHeaders.Name 字符串映射值是标题行的解析内容(即,它不包含头名称)
   * @return map of header values 标题值映射
   */
  public Map<EslHeaders.Name, String> getHeaders() {
    return headers;
  }

  /**
   * Convenience method 判断是够包含某个header
   *
   * @param headerName as a {@link EslHeaders.Name}
   * @return true if an only if there is a header entry with the supplied header name
   */
  public boolean hasHeader(EslHeaders.Name headerName) {
    return headers.containsKey(headerName);
  }

  /**
   * Convenience method 根据header获取解析内容
   *
   * @param headerName as a {@link EslHeaders.Name}
   * @return same as getHeaders().get( headerName )
   */
  public String getHeaderValue(EslHeaders.Name headerName) {
    return headers.get(headerName);
  }

  /**
   * Convenience method 判断header中是否包含Content-Length
   *
   * @return true if and only if a header exists with name "Content-Length"
   */
  public boolean hasContentLength() {
    return headers.containsKey(EslHeaders.Name.CONTENT_LENGTH);
  }

  /**
   * Convenience method 获取Content-Length
   *
   * @return integer value of header with name "Content-Length"
   */
  public Integer getContentLength() {
    if (contentLength != null) {
      return contentLength;
    }
    if (hasContentLength()) {
      contentLength = Integer.valueOf(headers.get(EslHeaders.Name.CONTENT_LENGTH));
    }
    return contentLength;
  }

  /**
   * Convenience method 获取Content-Type
   *
   * @return header value of header with name "Content-Type"
   */
  public String getContentType() {
    return headers.get(EslHeaders.Name.CONTENT_TYPE);
  }

  /**
   * Any received message body lines 任何接收到的消息正文行
   *
   * @return list with a string for each line received, may be an empty list
   */
  public List<String> getBodyLines() {
    return body;
  }

  /**
   * Used by the {@link EslFrameDecoder}.
   *
   * @param name
   * @param value
   */
  void addHeader(EslHeaders.Name name, String value) {
    log.trace("adding header [{}] [{}]", name, value);
    headers.put(name, value);
  }

  /**
   * Used by the {@link EslFrameDecoder}
   *
   * @param line
   */
  void addBodyLine(String line) {
    if (line == null) {
      return;
    }
    body.add(line);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("EslMessage: contentType=[");
    sb.append(getContentType());
    sb.append("] headers=");
    sb.append(headers.size());
    sb.append(", body=");
    sb.append(body.size());
    sb.append(" lines.");
    return sb.toString();
  }
}
