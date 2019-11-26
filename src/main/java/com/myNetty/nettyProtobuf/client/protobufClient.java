package com.myNetty.nettyProtobuf.client;

import com.myNetty.nettyProtobuf.protobufInitializer;
import com.myNetty.socket.client.myClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

public class protobufClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventGroup=new NioEventLoopGroup();
        try{
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new protobufClientInitializer());
            ChannelFuture channelFuture=bootstrap.connect("localhost",8889).sync();
            channelFuture.channel().closeFuture().sync();

        }finally {
            eventGroup.shutdownGracefully();
        }
    }
}
