package com.qtxln.socket;

import com.qtxln.client.SocketClient;
import com.qtxln.component.constants.socket.BasicListenEventNameEnum;
import com.qtxln.component.constants.socket.CallListenEventNameEnum;
import com.qtxln.component.util.cache.EhCacheUtils;
import com.qtxln.esl.FreeSwitchOperation;
import com.qtxln.model.esl.AgentInfo;
import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

/**
 * CallCenterEventHandler
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/15 10:05 上午
 * @since 1.0
 */
@Component
@Slf4j
public class CallCenterEventHandler {
  private final SocketIOServer socketIoServer;
  private final FreeSwitchOperation freeSwitchOperation;

  public CallCenterEventHandler(SocketIOServer socketIoServer, FreeSwitchOperation freeSwitchOperation) {
    this.socketIoServer = socketIoServer;
    this.freeSwitchOperation = freeSwitchOperation;
  }

  @OnConnect
  public void onConnect(SocketIOClient client) {
//    String skillGroup = getParamsByClient(client, "skillGroup");
//    String agent = getParamsByClient(client, "agent");
//    SocketClient.putClient(skillGroup, agent, client);
//    log.warn("技能组: {}, 坐席: {}, 已连接", skillGroup, agent);
  }

  @OnDisconnect
  public void onDisconnect(SocketIOClient client) {
//    String skillGroup = getParamsByClient(client, "skillGroup");
//    String agent = getParamsByClient(client, "agent");
//    SocketClient.removeClient(skillGroup, agent);
//    log.warn("技能组: {}, 坐席: {}, 已断开", skillGroup, agent);
  }

  @OnEvent("initAgentClient")
  public void initAgentClient(SocketIOClient client, Command command) {
    SocketClient.putClient(command.getSkillGroup(), command.getAgent(), client);
    log.warn("技能组: {}, 坐席: {}, 初始化", command.getSkillGroup(), command.getAgent());
    client.sendEvent("INIT_AGENT_CLIENT", true);
  }

  @OnEvent("destroyAgentClient")
  public void destroyAgentClient(SocketIOClient client, Command command) {
    SocketClient.removeClient(command.getSkillGroup(), command.getAgent());
    log.warn("技能组: {}, 坐席: {}, 销毁", command.getSkillGroup(), command.getAgent());
    client.sendEvent("DESTROY_AGENT_CLIENT", true);
  }

  @OnEvent("basic")
  public void onBasicEvent(SocketIOClient client, Command command) {
    String commandName = command.getCommandName();
    String extension = command.getExtension();
    String addr = command.getAddr();
    if (Objects.equals(BasicListenEventNameEnum.LOGIN.getName(), commandName)) {
      boolean login = freeSwitchOperation.login(addr, extension);
      if (login) {
        client.sendEvent("login", "成功");
      } else {
        client.sendEvent("login", "失败");
      }
    } else if (Objects.equals(BasicListenEventNameEnum.READY.getName(), commandName)) {
      freeSwitchOperation.ready(addr, extension);
      client.sendEvent("ready", "成功");
    } else if (Objects.equals(BasicListenEventNameEnum.NO_READY.getName(), commandName)) {
      freeSwitchOperation.noReady(addr, extension);
      client.sendEvent("noReady", "成功");
    } else if (Objects.equals(BasicListenEventNameEnum.LOGOUT.getName(), commandName)) {
      freeSwitchOperation.logout(addr, extension);
      client.sendEvent("logout", "成功");
    } else if (Objects.equals(BasicListenEventNameEnum.AGENT_STATUS.getName(), commandName)) {
      AgentInfo agentInfo = EhCacheUtils.get("eh-agent", extension, AgentInfo.class);
      if (agentInfo != null) {
        client.sendEvent("agentStatus", agentInfo.getAgentStatus());
      } else {
        client.sendEvent("agentStatus", "notExist");
      }
    }

  }

  @OnEvent("call")
  public void onCallEvent(SocketIOClient client, Command command) throws InterruptedException {
    String commandName = command.getCommandName();
    String extension = command.getExtension();
    String addr = command.getAddr();

    log.info("current: {}", JSON.toJSON(command.getCurrent()));

    if (Objects.equals(CallListenEventNameEnum.ANSWER.getName(), commandName)) {
      Thread.sleep(10000);
      freeSwitchOperation.answer(addr, command.getCurrent().getUniqueId(), extension);
    } else if (Objects.equals(CallListenEventNameEnum.HANG_UP.getName(), commandName)) {
      freeSwitchOperation.hungUp(addr, command.getCurrent().getUniqueId(), extension);
    } else if (Objects.equals(CallListenEventNameEnum.DIAL.getName(), commandName)) {
      freeSwitchOperation.dial(addr, extension, command.getDialNumber());
    } else if (Objects.equals(CallListenEventNameEnum.TRANSFER.getName(), commandName)) {
      freeSwitchOperation.transfer(addr, command.getCurrent().getUniqueId(), command.getDialNumber());
    } else if (Objects.equals(CallListenEventNameEnum.HOLD.getName(), commandName)) {
      freeSwitchOperation.hold(addr, command.getCurrent().getUniqueId());
    }
  }

  @PostConstruct
  private void autoStartup() {
    socketIoServer.start();
  }

  @PreDestroy
  private void autoStop() {
    if (socketIoServer != null) {
      socketIoServer.stop();
    }
  }

  /**
   * 获取请求参数
   *
   * @param client SocketIOClient
   * @return param
   */
  private String getParamsByClient(SocketIOClient client, String paramName) {
    return client.getHandshakeData().getSingleUrlParam(paramName);
  }

}

