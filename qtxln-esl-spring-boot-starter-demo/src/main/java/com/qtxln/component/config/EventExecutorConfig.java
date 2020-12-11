package com.qtxln.component.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * 时间处理配置类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-11 11:09
 * @since 1.0
 */
@Configuration
@EnableAsync
public class EventExecutorConfig {

  @Bean
  public Executor eventExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    // 设置最大线程数
    executor.setMaxPoolSize(5);
    // 设置核心线程数
    executor.setCorePoolSize(2);
    // 设置队列容量
    executor.setQueueCapacity(50);
    // 设置线程活跃时间（秒）
    executor.setKeepAliveSeconds(5);
    executor.setThreadNamePrefix("FsEventHandler-");
    // 设置拒绝策略
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.initialize();
    return executor;
  }

}
