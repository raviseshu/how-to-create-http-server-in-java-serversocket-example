package com.github.alexv1993.simplehttpserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by vendin on 11.10.2017.
 */
public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        final ServerSocket server = (ServerSocket) applicationContext.getBean("server");
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {


            try (Socket clientSocket = server.accept()) {
                InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }

                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));

            }
        }

    }
}
