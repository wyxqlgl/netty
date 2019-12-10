package com.myNetty.proto.server;

import io.grpc.Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    private Server server;
    public void start() throws Exception{
        this.server= ServerBuilder.forPort(8889).addService(new StudentServiceImpl()).build().start();
        System.out.println("server start!");
        //�ص����� ������������н�����ǰ������е�һ�γ��� �ص����Ӳ������кܳ��ĳ��� ֻ�����к̵ܶĳ���
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("�ر�jvm");
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
