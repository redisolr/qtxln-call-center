package com.qtxln.esl;

import com.qtxln.esl.inbound.option.InboundClientOption;
import com.qtxln.esl.transport.CommandResponse;
import com.qtxln.esl.transport.SendMsg;
import com.qtxln.esl.transport.message.EslMessage;

import java.util.function.Consumer;

/**
 * InboundClient
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:49 下午
 * @since 1.0
 */
public interface InboundClient extends com.qtxln.esl.InboundClientService {

  /**
   * 创建新实例
   *
   * @param option {@link com.qtxln.esl.inbound.option.InboundClientOption} 配置项
   * @return {@link com.qtxln.esl.InboundClient} 内联客户端
   */
  static com.qtxln.esl.InboundClient newInstance(InboundClientOption option) {
    return com.qtxln.esl.InboundClientFactory.getInstance().newInboundClient(option);
  }

  /**
   * 获取实例
   *
   * @return {@link com.qtxln.esl.InboundClient} 内联客户端
   */
  static com.qtxln.esl.InboundClient getInstance() {
    return com.qtxln.esl.InboundClientFactory.getInstance().getInboundClient();
  }

  /**
   * 获取客户可配置选项
   *
   * @return {@link com.qtxln.esl.inbound.option.InboundClientOption} 内联客户端配置项
   */
  InboundClientOption option();

  /**
   * 向fs服务器发送阻塞命令
   *
   * @param addr    Esl 服务地址
   * @param command fs api 命令
   * @param arg     fs api 命令参数
   * @return {@link com.qtxln.esl.transport.message.EslMessage} 返回结果
   */
  EslMessage sendSyncApiCommand(String addr, String command, String arg);

  /**
   * 向fs服务器发送阻塞命令
   *
   * @param addr    Esl 服务地址
   * @param command fs api 命令
   * @return {@link com.qtxln.esl.transport.message.EslMessage} 返回结果
   */
  EslMessage sendSyncApiCommand(String addr, String command);

  /**
   * 向fs服务器发送阻塞命令.
   *
   * @param addr    Esl 服务地址
   * @param command fs api 命令
   * @param arg     fs api 命令参数
   * @return 返回api执行结果的body信息
   */
  String sendSyncApiCommandReturnBody(String addr, String command, String arg);

  /**
   * 向fs服务器发送阻塞命令.
   *
   * @param addr    Esl 服务地址
   * @param command fs api 命令
   * @return 返回api执行结果的body信息
   */
  String sendSyncApiCommandReturnBody(String addr, String command);

  /**
   * 向fs服务器发送阻塞命令
   * 并将返回结果推送给执行的消费者.返回结果. {@link com.qtxln.esl.transport.message.EslMessage}
   *
   * @param addr     Esl 服务地址
   * @param command  fs api 命令
   * @param arg      fs api 命令参数
   * @param consumer {@link Consumer} 消费者
   */
  void sendSyncApiCommand(String addr, String command, String arg, Consumer<EslMessage> consumer);

  /**
   * 向fs服务器发送一个后台执行命令,服务器会同步响应一个UUID来标识执行结果,当服务器执行完毕,将触发一个带有执行结果的后台事件.
   *
   * @param addr    Esl 服务地址
   * @param command fs api 命令
   * @param arg     fs api 命令参数
   * @return Job-UUID
   */
  String sendAsyncApiCommand(String addr, String command, String arg);

  /**
   * 向fs服务器发送一个后台执行命令,服务器会同步响应一个UUID来标识执行结果,当服务器执行完毕,将触发一个带有执行结果的后台事件
   * 并将返回结果推送给执行的消费者.返回结果. {@link com.qtxln.esl.transport.message.EslMessage}
   *
   * @param addr     Esl 服务地址
   * @param command  fs api 命令
   * @param arg      fs api 命令参数
   * @param consumer {@link Consumer} 消费者
   */
  void sendAsyncApiCommand(String addr, String command, String arg, Consumer<String> consumer);

  /**
   * 设置订阅服务器的事件
   * 参数:
   * <pre>
   *   ALL
   *   CHANNEL_CREATE CHANNEL_DESTROY HEARTBEAT
   *   CUSTOM conference::maintenance
   *   CHANNEL_CREATE CHANNEL_DESTROY CUSTOM conference::maintenance sofia::register sofia::expire
   * </pre>
   * <p>
   * 对该方法的后续调用将替换以前设置的所有订阅.
   * </p>
   * 注意:当前实现只能处理“普通”事件.
   *
   * @param addr   Esl 服务地址
   * @param format 事件信息的格式化类型 { plain | xml | json}
   * @param events 事件 { all | 以空格隔开的事件列表 }
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse setEventSubscriptions(String addr, String format, String events);

  /**
   * 取消现有订阅的所有事件
   *
   * @param addr Esl 服务地址
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse cancelEventSubscriptions(String addr);

  /**
   * <p>
   * 将事件筛选器添加到此连接上的当前事件筛选器集.任何事件标题可以用作过滤器.
   * </p>
   * <p>
   * 注意,事件过滤器遵循"filter in"语义.也就是说,当应用过滤器时
   * 只接收过滤后的值.可以将多个过滤器添加到当前连接.
   * </p>
   * Example filters:
   * <pre>
   *    eventHeader        valueToFilter
   *    ----------------------------------
   *    Event-Name         CHANNEL_EXECUTE
   *    Channel-State      CS_NEW
   * </pre>
   *
   * @param addr          Esl 服务地址
   * @param eventHeader   事件头
   * @param valueToFilter 要匹配的值
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse addEventFilter(String addr, String eventHeader, String valueToFilter);

  /**
   * 从当前事件的筛选器集中删除筛选器 {@link com.qtxln.esl.InboundClient#addEventFilter}
   *
   * @param addr          Esl 服务地址
   * @param eventHeader   事件头
   * @param valueToFilter 要匹配的值
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse deleteEventFilter(String addr, String eventHeader, String valueToFilter);

  /**
   * 发送一个 {@link com.qtxln.esl.transport.SendMsg} 命令到fs.客户端必须包含一个UUID
   *
   * @param addr    Esl 服务地址
   * @param sendMsg {@link com.qtxln.esl.transport.SendMsg} 必须包含通话UUID
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse sendMessage(String addr, SendMsg sendMsg);

  /**
   * 设置日志输出级别
   *
   * @param addr  Esl 服务地址
   * @param level 使用和fs控制台相同的参数配置
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse setLoggingLevel(String addr, String level);

  /**
   * 禁用设置的日志级别
   *
   * @param addr Esl 服务地址
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse cancelLogging(String addr);

  /**
   * 关闭socket连接
   *
   * @param addr Esl 服务地址
   * @return {@link com.qtxln.esl.transport.CommandResponse} 服务器响应
   */
  CommandResponse close(String addr);

}

