package com.tomato.framework.demo.server.service.impl;

import com.tomato.framework.demo.facade.dto.PostDemo;
import com.tomato.framework.demo.facade.service.HelloWorld;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld {
    
    public HelloWorldImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String hello(String hello) throws RemoteException {
        System.out.println("服务端接收数据：" + hello);
        return hello;
    }
    
    @Override
    public PostDemo post(PostDemo postDemo) throws RemoteException {
        postDemo.setTime(new Date());
        return postDemo;
    }
}
