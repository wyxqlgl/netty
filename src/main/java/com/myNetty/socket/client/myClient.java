package com.myNetty.socket.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class myClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventGroup=new NioEventLoopGroup();
        try{
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new myClientInitializer());
            ChannelFuture channelFuture=bootstrap.connect("localhost",8889).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            eventGroup.shutdownGracefully();
        }
    }
}
