package com.bobo.netty.server;

import com.bobo.RequestHandler;
import com.bobo.registry.ServerRegistry;
import com.bobo.rpc.entity.RpcRequest;
import com.bobo.rpc.entity.RpcResponse;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author by bobo
 * @Description RPC Server handler
 * @Date 2023/3/1 13:39
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<RpcRequest> {
    private static final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
    private static RequestHandler requestHandler;
    private ServerRegistry serverRegistry;

    static {
        requestHandler = new RequestHandler();
    }

    public NettyServerHandler(ServerRegistry serverRegistry) {
        this.serverRegistry = serverRegistry;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequest msg) throws Exception {
        try {
            logger.info("服务器接受请求:{}", msg);
            String interfaceName = msg.getInterfaceName();
            Object service = serverRegistry.getService(interfaceName);
            Object result = requestHandler.handle(msg, service);
            ChannelFuture future = ctx.writeAndFlush(RpcResponse.success(result));
            future.addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("处理过程调用时有错误发生");
        cause.printStackTrace();
        ctx.close();
    }
}
