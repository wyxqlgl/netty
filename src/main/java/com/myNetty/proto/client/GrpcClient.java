package com.myNetty.proto.client;

import com.myNetty.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8889).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse= blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("ÕÅÈý").build());
        String Realname= myResponse.getRealname();
        System.out.println(Realname);
        Iterator<StudentResponse> iterator=blockingStub.getStudentsByAge(StudentResquest.newBuilder().setAge(22).build());
        while (iterator.hasNext()){
            StudentResponse  studentResponse=iterator.next();
            System.out.print(studentResponse.getAge()+" ");
            System.out.print(studentResponse.getCity()+" ");
            System.out.print(studentResponse.getName()+" ");

        }
    }
}
