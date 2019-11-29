package com.myNetty.thrift;

import org.apache.thrift.TException;

public class PersionServiceImpl implements PersionService.Iface {
    @Override
    public Persion getPersonByUserName(String username) throws DataException, TException {
        System.out.println("on client getPersonByUserName"+username);
        Persion persion=new Persion();
        persion.setAge(20);
        persion.setUsername("Aimm");
        persion.setAgeIsSet(false);
        return persion;
    }

    @Override
    public void savePersion(Persion persion) throws DataException, TException {
        System.out.println("on client savePersion"+persion);

    }
}
