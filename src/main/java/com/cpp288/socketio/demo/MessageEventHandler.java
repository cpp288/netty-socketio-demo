package com.cpp288.socketio.demo;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 消息事件处理
 *
 * @author chenjian
 * @date 2020-05-08 10:27:18
 */
@Slf4j
@Component
public class MessageEventHandler {

    @OnConnect
    public void onConnect(SocketIOClient client) {
        log.info("客户端【{}】已连接", client.getSessionId());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        log.info("客户端【{}】已断开", client.getSessionId());
    }

    @OnEvent(value = "testEvent")
    public void onEvent(SocketIOClient client, AckRequest request, String data) {
        log.info("监听到客户端【{}】消息：{}", client.getSessionId(), data);
    }
}
