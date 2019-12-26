package com.myNetty.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Niotest7 {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        int[] ports = new int[6];
        ports[0] = 5001;
        ports[1] = 5002;
        ports[2] = 5003;
        ports[3] = 5004;
        ports[4] = 5005;
        ports[5] = 5006;
        for (int i = 0; i < ports.length; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //阻塞与非阻塞
            serverSocketChannel.configureBlocking(false);
            ServerSocket socket = serverSocketChannel.socket();
            socket.bind(new InetSocketAddress(ports[i]));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口：" + ports[i]);
        }
        while (true) {
            //表示返回key的数量
            int select = selector.select();
            System.out.println("select:" + select);
            //获取key的列表
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys" + selectionKeys);
            //监听多个通道
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //如果有连接
                if (selectionKey.isAcceptable()) {
                    //如果有链接建立个通道
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    //接受连接
                    SocketChannel accept = channel.accept();
                    //是否阻塞 不阻塞
                    accept.configureBlocking(false);
                    //注册到这个通道
                    accept.register(selector,SelectionKey.OP_READ);
                    //移除这个selectionKey
                    iterator.remove();
                    System.out.println("获取客户端连接"+channel);
                }else if (selectionKey.isReadable()){ //判读是否可读
                    SocketChannel socketChannel=(SocketChannel)selectionKey.channel();
                    int byteRead=0;
                    while (true){
                        ByteBuffer byteBuffer=ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read=socketChannel.read(byteBuffer);
                        if(read<=0){
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteRead +=read;
                    }
                    System.out.println("读取:"+byteRead+",来自于："+socketChannel);
                    //移除这个selectionKey
                    iterator.remove();
                }

            }

        }

    }

}

