package com.myNetty.thrift.service;

import com.myNetty.thrift.PersionService;
import com.myNetty.thrift.PersionServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class ThirftServer {
    public static void main(String[] args) throws Exception{
        TNonblockingServerSocket socket=new TNonblockingServerSocket(8889);
        THsHaServer.Args arg=new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersionService.Processor<PersionServiceImpl> processor=new PersionService.Processor<>(new PersionServiceImpl());
        //协议层
        arg.protocolFactory(new TCompactProtocol.Factory());
        //传输层
        arg.transportFactory(new TFramedTransport.Factory());

        arg.processorFactory(new TProcessorFactory(processor));
        TServer server=new THsHaServer(arg);
        System.out.println("server is started");
        server.serve();
    }
}
