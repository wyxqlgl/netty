package com.myNetty.socket.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class myService {
    public static void main(String[] args) {
        //两个线程组接受
        EventLoopGroup boosGroup=new NioEventLoopGroup();
        //处理线程
        EventLoopGroup workGroup =new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(boosGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new myServerInitializer());
            ChannelFuture channelFuture=serverBootstrap.bind(8889).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            boosGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
