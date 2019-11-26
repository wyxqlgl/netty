package com.myNetty.protobuf;

public class protobufTest {
    public static void main(String[] args) throws Exception {
        DataInfo.Student build = DataInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("北京").build();
        byte[] studentsByteArray=build.toByteArray();

        DataInfo.Student student=DataInfo.Student.parseFrom(studentsByteArray);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getAddress());

    }
}
