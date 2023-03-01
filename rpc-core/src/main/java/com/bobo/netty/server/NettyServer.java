package com.bobo.netty.server;

import com.bobo.RpcServer;
import com.bobo.codec.CommonDecoder;
import com.bobo.codec.CommonEncoder;
import com.bobo.registry.DefaultServiceRegistry;
import com.bobo.registry.ServerRegistry;
import com.bobo.serializer.JsonSerializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by bobo
 * @Description netty服务端
 * @Date 2023/3/1 10:22
 */
public class NettyServer implements RpcServer {
    private static final Logger logger = LoggerFactory.getLogger(RpcServer.class);
    private final ServerRegistry serverRegistry;

    public NettyServer(ServerRegistry serverRegistry) {
        this.serverRegistry = serverRegistry;
    }

    @Override
    public void start(int port) {
        NioEventLoopGroup bootGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bootGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .option(ChannelOption.SO_BACKLOG, 256)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //添加编码器
                            pipeline.addLast(new CommonEncoder(new JsonSerializer()))
                                    .addLast(new CommonDecoder())
                                    .addLast(new NettyServerHandler(serverRegistry));

                        }
                    });
            ChannelFuture future = serverBootstrap.bind(port).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error("启动服务时发生错误", e);
        } finally {
            bootGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
