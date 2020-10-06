package com.softwarefoundation.empresaspringbootmvcthymeleaf.util;

import org.springframework.util.SocketUtils;


public class SpringUtil {

    public static void setRandom(int minPort, int maxPort){
        try{
            String serverPort = System.getProperty("server.port", System.getenv("SERVER_PORT"));
            if(serverPort != null && serverPort.isEmpty()){
                int port = SocketUtils.findAvailableTcpPort(minPort,maxPort);
                System.setProperty("server.port",String.valueOf(port));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
