package com.myNetty.nio;

import java.io.FileInputStream;

public class Iotest {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream=new FileInputStream("D:/en.txt");
        byte b[] =new byte[10];;
        fileInputStream.read(b);
    }
}
