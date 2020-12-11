package com.qtxln.component.util.cache;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁接口,不可重入锁
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/20 13:44 下午
 * @since 1.0
 */
public interface CacheLock extends Closeable {
  /**
   * 释放锁
   */
  @Override
  default void close() {
    unlock();
  }

  /**
   * 解锁
   */
  void unlock();

  /**
   * 尝试加锁
   *
   * @return true 代表成功加锁
   */
  boolean tryLock();

  /**
   * 尝试加锁
   *
   * @param time 超过指定时间后自动释放
   * @param unit 单位
   * @return true 代表成功加锁
   */
  boolean tryLock(long time, TimeUnit unit);
}
