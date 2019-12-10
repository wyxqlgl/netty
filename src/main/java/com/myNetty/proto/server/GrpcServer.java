package com.myNetty.proto.server;

import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    private Server server;
    public void start() throws Exception{
        this.server= ServerBuilder.forPort(8889).addService(new StudentServiceImpl()).build().start();
        System.out.println("server start!");
        //回调钩子 是在虚拟机运行结束以前最后运行的一段程序 回调钩子不能运行很长的程序 只能运行很短的程序
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("关闭jvm");
            GrpcServer.this.stop();
        }));
    }

    public void stop(){
        if (null !=this.server){
            this.server.shutdown();
        }
    }
    public void awaitTermination() throws Exception{
        if (null !=this.server){
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception{
        GrpcServer server=new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}
