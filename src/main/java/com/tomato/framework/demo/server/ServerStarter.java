package com.tomato.framework.demo.server;

import com.google.common.collect.ImmutableMap;
import com.tomato.framework.demo.facade.service.HelloWorld;
import com.tomato.framework.demo.server.service.impl.HelloWorldImpl;
import com.tomato.framework.plugin.rmi.register.Register;
import com.tomato.framework.plugin.rmi.register.ZKRegister;
import com.tomato.framework.plugin.rmi.server.RmiServer;
import com.tomato.framework.plugin.rmi.server.Server;
import java.rmi.Remote;
import java.util.Map;

public class ServerStarter {
    
    public static void main(String[] args) throws Exception {
        //RMI 注册
//        Register register = new RmiRegister(HelloWorld.class.getName(), new HelloWorldImpl());
        Map<String, Remote> map = ImmutableMap
            .of(HelloWorld.class.getName(), new HelloWorldImpl());
        Register register = new ZKRegister("127.0.0.1:2181" , map);
        Server rmiServer = new RmiServer("rmi://127.0.0.1:18081", register);
        rmiServer.start();
//        rmiServer.stop();
    }
}
