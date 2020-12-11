package com.qtxln.component.util.cache;

import lombok.SneakyThrows;
import net.sf.ehcache.Ehcache;

import java.util.concurrent.TimeUnit;

/**
 * ehCache 单机锁，可以重入锁
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/20 13:44 下午
 * @since 1.0
 */
class EhCacheLockImpl implements CacheLock {

  private Ehcache ehcache;
  private String key;

  public EhCacheLockImpl(Ehcache ehcache, String key) {
    this.ehcache = ehcache;
    this.key = key;
  }

  @Override
  public void unlock() {
    if (ehcache.isWriteLockedByCurrentThread(key)) {
      ehcache.releaseWriteLockOnKey(key);
    }
  }

  @SneakyThrows
  @Override
  public boolean tryLock() {
    return ehcache.tryWriteLockOnKey(key, 0);
  }

  @SneakyThrows
  @Override
  public boolean tryLock(long time, TimeUnit unit) {
    return ehcache.tryWriteLockOnKey(key, unit.toMillis(time));
  }
}
