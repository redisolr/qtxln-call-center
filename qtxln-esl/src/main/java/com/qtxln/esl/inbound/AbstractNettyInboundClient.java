package com.qtxln.esl.inbound;

import com.qtxln.esl.InboundClientService;
import com.qtxln.esl.inbound.handler.InboundChannelHandler;
import com.qtxln.esl.inbound.listener.ChannelEventListener;
import com.qtxln.esl.inbound.option.InboundClientOption;
import com.qtxln.esl.transport.message.EslFrameDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * AbstractNettyInboundClient
 *
 * @author 秦腾
 * @version 1.0
 * @date 2020/5/11 14:43 下午
 * @since 1.0
 */
public abstract class AbstractNettyInboundClient implements ChannelEventListener, com.qtxln.esl.InboundClientService {

  final Bootstrap bootstrap;
  final EventLoopGroup workerGroup;
  final ExecutorService publicExecutor;

  final InboundClientOption option;

  final Logger log = LoggerFactory.getLogger(getClass());

  AbstractNettyInboundClient(InboundClientOption option) {
    this.option = option;

    bootstrap = new Bootstrap();

    publicExecutor = new ScheduledThreadPoolExecutor(option.publicExecutorThread(),
        new BasicThreadFactory.Builder().namingPattern("publicExecutor-%d").daemon(true).build());

    workerGroup = new NioEventLoopGroup(option.workerGroupThread());
    bootstrap.group(workerGroup)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.TCP_NODELAY, true)
        .option(ChannelOption.SO_KEEPALIVE, false)
        .option(ChannelOption.SO_SNDBUF, option.sndBufSize())
        .option(ChannelOption.SO_RCVBUF, option.rcvBufSize())
        .handler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast("encoder", new StringEncoder());
            pipeline.addLast("decoder", new EslFrameDecoder(8192));
            // now the inbound client logic
            pipeline.addLast("clientHandler", new InboundChannelHandler(AbstractNettyInboundClient.this, publicExecutor, option.disablePublicExecutor()));
          }
        });
  }

}

