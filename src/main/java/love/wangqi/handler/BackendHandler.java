package love.wangqi.handler;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: wangqi
 * @description:
 * @date: Created in 2018/5/28 下午4:57
 */
public class BackendHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(BackendHandler.class);

    private ChannelHandlerContext ctx;

    BackendHandler(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.ctx.channel().writeAndFlush(msg).addListener(ChannelFutureListener.CLOSE);
        ctx.channel().close();
    }
}
