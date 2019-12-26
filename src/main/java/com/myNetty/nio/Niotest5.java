package com.myNetty.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Niotest5 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile=new RandomAccessFile("d:/en.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        //文件锁
        FileLock lock = channel.lock(3,5,true);
        System.out.println(lock.isValid()); //是否有锁
        lock.release();//释放锁
        channel.close();

    }
}
