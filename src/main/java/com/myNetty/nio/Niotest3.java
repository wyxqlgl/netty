package com.myNetty.nio;

import java.nio.ByteBuffer;

public class Niotest3 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);
        ByteBuffer byteBuffers=ByteBuffer.allocateDirect(10);
//        ByteBuffer byteBuffers=ByteBuffer.allocate(10);

        for(int i=0;i<10;i++){
            byteBuffer.put((byte) i);
        }
        byteBuffer.position(5);
        byteBuffer.limit(10);
        //slice 方法是取bytebuffer中的某些元素指向位置 和byteBuffer共享一个ByteBuffer
        ByteBuffer slice = byteBuffer.slice();

//        byteBuffer.asReadOnlyBuffer()
        while (slice.remaining()>0){
            System.out.println(slice.get());
        }
    }
}
