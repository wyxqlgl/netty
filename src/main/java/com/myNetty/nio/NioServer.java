package com.myNetty.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2019/12/25 16:11
 **/
public class NioServer {
    //客户端连接信息
    private  static Map<String,SocketChannel> clientMap=new HashMap<>();

    public static void main(String[] args) throws Exception{
        //关注连接
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8889));
        //定义选择器
        Selector selector=Selector.open();
        //只有channel 有注册 把channel注册到selector上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            try {
                int select = selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.stream().forEach(selectionKey -> {
                    final SocketChannel accept;
                    try {
                        if (selectionKey.isAcceptable()) {//判断新到来的连接
                            //关注的数据读取
                            ServerSocketChannel socketChannel = (ServerSocketChannel) selectionKey.channel();
                            accept = socketChannel.accept();
                            accept.configureBlocking(false);
                            accept.register(selector,SelectionKey.OP_READ);
                            String key="["+ UUID.randomUUID().toString() +"]";
                            clientMap.put(key,accept);
                        }else if (selectionKey.isReadable()){
                            accept=(SocketChannel)selectionKey.channel();
                            ByteBuffer byteBuffer=ByteBuffer.allocate(512);
                            int count = accept.read(byteBuffer);
                            byteBuffer.flip();
                            Charset character=Charset.forName("utf-8");
                            String receivedMessage=String.valueOf(character.decode(byteBuffer).array());
                            System.out.println("<"+accept.getRemoteAddress()+">:"+receivedMessage);

                            Set<String> keySet = clientMap.keySet();
                            Iterator<String> iterator = keySet.iterator();
                            while (iterator.hasNext()){
                                String keys=iterator.next();
                                SocketChannel socketChannel=   clientMap.get(keys);
                                ByteBuffer byteBuffer1=ByteBuffer.allocate(512);
                                byteBuffer1.put((keys+":"+receivedMessage).getBytes());
                                byteBuffer1.flip();
                                socketChannel.write(byteBuffer1);

                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        selectionKeys.clear();
                    }
                });
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        }

    }
}
