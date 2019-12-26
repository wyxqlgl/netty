package com.myNetty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO
 *
 * @author Administrator
 * @date 2019/12/26 9:45
 **/
public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector=Selector.open();
            //表示客户端
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost",8889));
            while (true){
                int select = selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.stream().forEach(selectionKey -> {
                    //表示已经与服务端已将建好了连接
                    if(selectionKey.isConnectable()){
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        //客户端是否是挂起状态
                        if(channel.isConnectionPending()){
                            try {
                                //获取连接
                                channel.finishConnect();
                                ByteBuffer byteBuffer=ByteBuffer.allocate(512);
//
                                byteBuffer.put(LocalTime.now().toString().getBytes());
                                byteBuffer.flip();
                                channel.write(byteBuffer);
                                //发送消息用现成是
                                ExecutorService executorService= Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                                executorService.submit(()->{
                                    while (true){
                                        byteBuffer.clear();
                                        Scanner sc = new Scanner(System.in);
                                        String name = sc.nextLine();
                                        byteBuffer.put(name.getBytes());
                                        byteBuffer.flip();
                                        channel.write(byteBuffer);
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        try {
                            channel.register(selector,SelectionKey.OP_READ);
                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        }
                    }else if(selectionKey.isReadable()){
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer=ByteBuffer.allocate(512);
                        try {
                            int read = channel.read(byteBuffer);
                            if (read > 0) {
                              String message=  String.valueOf(byteBuffer.array());
                                System.out.println("<"+channel.getRemoteAddress()+">:"+message);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                selectionKeys.clear();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
