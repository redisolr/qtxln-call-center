package com.qtxln.component.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SocketIoProperties
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 10:00 上午
 * @since 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "socket.io")
public class SocketIOProperties {

    private String host;
    private int port;
    private int bossCount;
    private int workCount;
    private boolean allowCustomRequests;
    private int upgradeTimeout;
    private int pingTimeout;
    private int pingInterval;

}

