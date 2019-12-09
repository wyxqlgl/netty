package com.myNetty.thrift.client;
import com.myNetty.thrift.Persion._Fields;

import com.myNetty.thrift.Persion;
import com.myNetty.thrift.PersionService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport tTransport=new TFramedTransport(new TSocket("localhost",8889),600);
        TProtocol protocol=new TCompactProtocol(tTransport);
        PersionService.Client client=new PersionService.Client(protocol);
         try {
             tTransport.open();
             Persion ammmm = client.getPersonByUserName("Ammmm");
             System.out.println(ammmm.getAge());
             System.out.println(ammmm.getUsername());
             Persion persion=new Persion();
             persion.setUsername("tom");
             persion.setUsernameIsSet(false);
             persion.setAge(0);


//             client.savePersion(persion);
         }catch (Exception e){
             throw new RuntimeException(e.getMessage(),e);
         }finally {
             tTransport.close();
         }
    }
}