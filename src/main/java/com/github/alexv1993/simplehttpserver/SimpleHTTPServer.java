package com.github.alexv1993.simplehttpserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.ServerSocket;

/**
 * Created by vendin on 11.10.2017.
 */
public class SimpleHTTPServer {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        final ServerSocket server = (ServerSocket) applicationContext.getBean("server");
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {

        }

    }
}
