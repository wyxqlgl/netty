package com.myNetty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class Niotext1 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fileInputStream=new FileOutputStream("d:/en.txt");
        //转nio
        FileChannel fileChannel= fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(5000);
        byte [] a="我靠 写进去了".getBytes();

        for (int i=0;i<a.length;i++) {
            byteBuffer.put(a[i]);
        }
        //写进去必须反转一下
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileChannel.close();
   
    }
}
