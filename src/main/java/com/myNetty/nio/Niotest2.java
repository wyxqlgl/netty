package com.myNetty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class Niotest2 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream=new FileInputStream("d:/en.txt");
        FileOutputStream outputStream=new FileOutputStream("d:/en.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(500);
        IntBuffer intBuffer=IntBuffer.allocate(23);

        String t="sdfsdf";
        byte[] bytes=t.getBytes();
        byteBuffer.put(bytes);
        while (true){
            byteBuffer.clear();
            int a=inputStreamChannel.read(byteBuffer);
            if(-1==a){
                break;
            }
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
        }
        inputStreamChannel.close();
        outputStreamChannel.close();
   }

}
