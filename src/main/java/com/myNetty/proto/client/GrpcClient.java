package com.myNetty.proto.client;

import com.myNetty.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) throws Exception{
        //传输一个对象
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8889).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse= blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("张三").build());
        String Realname= myResponse.getRealname();
        System.out.println(Realname);

//接收端是流
        Iterator<StudentResponse> iterator=blockingStub.getStudentsByAge(StudentResquest.newBuilder().setAge(22).build());
        while (iterator.hasNext()){
            StudentResponse  studentResponse=iterator.next();
            System.out.print(studentResponse.getAge()+" ");
            System.out.print(studentResponse.getCity()+" ");
            System.out.print(studentResponse.getName()+" ");

        }

//传输端是流
        StudentServiceGrpc.StudentServiceStub studentServiceStub=StudentServiceGrpc.newStub(managedChannel);
        StreamObserver<StudentResponseList> studentResponseListStreamObserver=new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(en->{
                    System.out.println(en.getName());
                    System.out.println(en.getCity());
                    System.out.println(en.getAge());

                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed !");
            }
        };
        StreamObserver<StudentResquest> studentResquestStreamObserver=studentServiceStub.getStudentWrapperByAges(studentResponseListStreamObserver);
        studentResquestStreamObserver.onNext(StudentResquest.newBuilder().setAge(20).build());
        studentResquestStreamObserver.onNext(StudentResquest.newBuilder().setAge(30).build());
        studentResquestStreamObserver.onNext(StudentResquest.newBuilder().setAge(40).build());
        studentResquestStreamObserver.onCompleted();



//接收端和传输端都是流
        StreamObserver<StreamRequest> streamRequestStreamObserver=studentServiceStub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");

            }
        });

        for (int i=0;i<=10;i++){
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalTime.now().toString()).build());
            Thread.sleep(10000);
        }


    }
}
