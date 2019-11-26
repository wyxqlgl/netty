package com.myNetty.nettyProtobuf.client;

import com.myNetty.nettyProtobuf.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class protobufClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int num=new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage=null;
        if (0==num){
             myMessage=MyDataInfo.MyMessage.newBuilder().setDateType(MyDataInfo.MyMessage.DataType.Persontype).setPerson(MyDataInfo.Person.newBuilder().setName("张三").setAddress("北京").setAge(20)).build();
        }else if (1==num){
            myMessage=MyDataInfo.MyMessage.newBuilder().setDateType(MyDataInfo.MyMessage.DataType.DogType).setDog(MyDataInfo.Dog.newBuilder().setName("张三").setAge(20)).build();

        }else if (2==num){
            myMessage=MyDataInfo.MyMessage.newBuilder().setDateType(MyDataInfo.MyMessage.DataType.CatType).setCat(MyDataInfo.Cat.newBuilder().setName("张三").setCity("上海")).build();

        }else {
            new Exception("");
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
