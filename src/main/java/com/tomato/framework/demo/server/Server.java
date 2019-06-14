package com.tomato.framework.demo.server;

import com.tomato.framework.demo.facade.service.HelloWorld;
import com.tomato.framework.demo.facade.service.impl.HelloWorldImpl;
import com.tomato.framework.plugin.rmi.register.RmiRegister;
import com.tomato.framework.plugin.rmi.server.RmiServer;

public class Server {
    
    public static void main(String[] args) throws Exception {
        RmiRegister register = new RmiRegister(HelloWorld.class.getSimpleName(), new HelloWorldImpl());
        RmiServer rmiServer = new RmiServer(register);
        rmiServer.start();
//        rmiServer.stop();
    }
}
