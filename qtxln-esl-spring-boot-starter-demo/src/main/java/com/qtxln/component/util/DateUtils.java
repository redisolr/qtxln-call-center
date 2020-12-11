package com.qtxln.component.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/8/22 16:35 下午
 * @since 1.0
 */
public class DateUtils {
  private DateUtils() {
  }

  public static LocalDateTime strToLocalDateTime(String dateTime) {
    return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  public static LocalDateTime microsecondsToLocalDateTime(String nanosecond) {
    return microsecondsToLocalDateTime(Long.parseLong(nanosecond));
  }

  public static LocalDateTime microsecondsToLocalDateTime(Long nanosecond) {
    long second = TimeUnit.MICROSECONDS.toSeconds(nanosecond);
    return LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));
  }

  public static long betweenSecond(LocalDateTime start, LocalDateTime end) {
    Duration duration = Duration.between(start, end);
    return duration.getSeconds();
  }

  public static long betweenSecond(String start, String end) {
    return betweenSecond(strToLocalDateTime(start), strToLocalDateTime(end));
  }

}
