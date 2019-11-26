package com.myNetty.nettyProtobuf;

import com.myNetty.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class protobufHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dateType = msg.getDateType();

        if(dateType==MyDataInfo.MyMessage.DataType.Persontype){
            System.out.println(msg.getPerson().getAddress());
            System.out.println(msg.getPerson().getAge());
            System.out.println(msg.getPerson().getName());
        }else if(dateType==MyDataInfo.MyMessage.DataType.DogType){

            System.out.println(msg.getPerson().getAge());
            System.out.println(msg.getPerson().getName());

        }else {
            System.out.println(msg.getCat().getName());
            System.out.println(msg.getCat().getCity());
        }
    }
}
