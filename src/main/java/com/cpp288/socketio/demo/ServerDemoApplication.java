package com.cpp288.socketio.demo;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

/**
 * bootstrap
 *
 * @author chenjian
 * @date 2020-05-08 10:06:12
 */
@SpringBootApplication
public class ServerDemoApplication {

    private final SocketIOServer socketIOServer;

    @Autowired
    public ServerDemoApplication(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerDemoApplication.class, args);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener() {
        return event -> socketIOServer.start();
    }
}
