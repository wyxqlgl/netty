package com.myNetty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myChatClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup eventGroup=new NioEventLoopGroup();
        try{
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventGroup).channel(NioSocketChannel.class).handler(new myChatClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8889).sync().channel();
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                channel.writeAndFlush(br+"\r\n");
            }
        }finally {
            eventGroup.shutdownGracefully();

        }
    }
}
