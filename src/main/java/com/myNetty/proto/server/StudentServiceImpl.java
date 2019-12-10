package com.myNetty.proto.server;

import com.myNetty.proto.*;
import io.grpc.stub.StreamObserver;

import java.io.PrintStream;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        String userName=request.getUsername();
        System.out.println("接收到客户端信息："+userName);
        responseObserver.onNext(MyResponse.newBuilder().setRealname("李四").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentResquest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接受客户端信息"+request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(20).setCity("北京").setName("张珊").getDefaultInstanceForType());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(21).setCity("北京").setName("李思").getDefaultInstanceForType());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(22).setCity("北京").setName("王武").getDefaultInstanceForType());
        responseObserver.onCompleted();

    }
}
