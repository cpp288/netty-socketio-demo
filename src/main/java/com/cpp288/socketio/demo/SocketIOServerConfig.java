package com.cpp288.socketio.demo;

import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * server 配置
 *
 * @author chenjian
 * @date 2020-05-08 10:10:25
 */
@Configuration
public class SocketIOServerConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        SocketConfig sockConfig = new SocketConfig();
        // 地址复用
        sockConfig.setReuseAddress(true);
        config.setSocketConfig(sockConfig);
        // nginx配置成具体ip或者不配好像会有问题，建议设定为0.0.0.0
        config.setHostname("0.0.0.0");
        config.setPort(9090);
        // session id随机，为false时，在同一个浏览器打开多个连接时，session id为同一个
        config.setRandomSession(true);
        // 权限验证 do nothing
        config.setAuthorizationListener(data -> true);
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        // 注解扫描
        return new SpringAnnotationScanner(socketServer);
    }
}
