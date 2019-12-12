package com.myNetty.proto.server;

import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    private Server server;
    public void start() throws Exception{
        this.server= ServerBuilder.forPort(8889).addService(new StudentServiceImpl()).build().start();
        System.out.println("server start!");
        //回调钩子 就是在jvm 将要关闭的时候调用的函数 但是回调钩子 不能执行大数据量的操作 只能进行简单的数据操作
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("jvm");
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
