package com.myNetty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

public class HearBeatHandler extends ChannelInboundHandlerAdapter {
    /**
     * 触发某个事件得到调用
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event=(IdleStateEvent)evt;
            String EventType="";
            switch (event.state()){
                case READER_IDLE:
                    EventType="读空闲";
                    break;
                case WRITER_IDLE:
                    EventType="写空闲";
                    break;
                case ALL_IDLE:
                    EventType="读写空闲";
                    break;

            }
            System.out.println("现在所处的状态："+EventType);
            ctx.channel().close();
        }
    }

}
