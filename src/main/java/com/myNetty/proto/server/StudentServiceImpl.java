package com.myNetty.proto.server;

import com.myNetty.proto.*;
import io.grpc.stub.StreamObserver;

import java.io.PrintStream;
import java.util.UUID;

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

    @Override
    public StreamObserver<StudentResquest> getStudentWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentResquest>() {
            @Override
            public void onNext(StudentResquest value) {
                System.out.println(value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse studentResponse= StudentResponse.newBuilder().setName("李思").setCity("北京").setAge(20).build();
                StudentResponse studentResponset= StudentResponse.newBuilder().setName("王武").setCity("天津").setAge(20).build();
                StudentResponseList studentResponseList= StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponset).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }


        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();

            }
        };
    }
}
