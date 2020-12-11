package com.qtxln.client;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.SocketIOClient;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Collection;

/**
 * socket客户端类
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020-09-16 17:32
 * @since 1.0
 */
public class SocketClient {

  public static final Table<String, String, SocketIOClient> socketClientTable = SocketClientEnum.INSTANCE.getInstance();

  public static void putClient(String skillGroup, String agent, SocketIOClient client) {
    if (socketClientTable.contains(skillGroup, agent)) {
      SocketIOClient socketIoclient = socketClientTable.get(skillGroup, agent);
      if (socketIoclient != null) {
        socketIoclient.disconnect();
      }
    }
    socketClientTable.put(skillGroup, agent, client);
  }

  public static void removeClient(String skillGroup, String agent) {
    socketClientTable.remove(skillGroup, agent);
  }

  public static void sendMessage(String skillGroup, String event, Object object) {
    Collection<SocketIOClient> socketIoClients = socketClientTable.row(skillGroup).values();
    socketIoClients.forEach(socketIoClient -> socketIoClient.sendEvent(event, JSON.toJSONString(object)));
  }

  enum SocketClientEnum {
    /**
     * 单例创建socket容器
     */
    INSTANCE;

    private final Table<String, String, SocketIOClient> socketClientTable;

    SocketClientEnum() {
      socketClientTable = HashBasedTable.create();
    }

    public Table<String, String, SocketIOClient> getInstance() {
      return socketClientTable;
    }

  }

}
