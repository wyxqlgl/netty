package com.myNetty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
//关于buffer的Scattering 与 Gathering
public class Niotest6 {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        InetSocketAddress address=new InetSocketAddress(8889);
        serverSocketChannel.socket().bind(address);
        int mesageLength=2+3+4;
        ByteBuffer[] byteBuffers=new ByteBuffer[3];
        byteBuffers[0]=ByteBuffer.allocate(2);
        byteBuffers[1]=ByteBuffer.allocate(3);
        byteBuffers[2]=ByteBuffer.allocate(4);
        SocketChannel socketChannel=serverSocketChannel.accept();
        while (true){
            int byteRead=0;
            while (byteRead<mesageLength){
                long read = socketChannel.read(byteBuffers);
                byteRead +=read;
                System.out.println("byteRead"+byteRead);
                Arrays.asList(byteBuffers).stream().map(byteBuffer -> "positon:"+byteBuffer.position()+",limit:"+byteBuffer.limit()).forEach(System.out::println);

            }
            Arrays.asList(byteBuffers).stream().forEach(byteBuffer -> {
                byteBuffer.flip();
            });
            long byteWrite=0;
            while (byteWrite<mesageLength){
                Long r=socketChannel.write(byteBuffers);
                byteWrite +=r;
            }
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());
            System.out.println("byteRead:"+byteRead+",byteWrite:"+byteWrite);
        }


    }
}
