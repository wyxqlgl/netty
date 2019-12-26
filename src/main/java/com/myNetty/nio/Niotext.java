package com.myNetty.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Niotext {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream=new FileInputStream("d:/en.txt");
        //转nio
        FileChannel fileChannel= fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(5000);
        fileChannel.read(byteBuffer);
        //写转成读 读转换写 转换方法
        byteBuffer.flip();
        while (byteBuffer.remaining()>0){
            System.out.println((char) byteBuffer.get());
            System.out.println("limt()"+byteBuffer.limit());
            System.out.println("position()"+byteBuffer.position());

        }
        fileChannel.close();
    }
}
