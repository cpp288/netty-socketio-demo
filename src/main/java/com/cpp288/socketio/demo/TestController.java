package com.cpp288.socketio.demo;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * test controller
 *
 * @author chenjian
 * @date 2020-05-08 14:04:14
 */
@RestController(value = "test")
public class TestController {

    @Resource
    private SocketIOServer socketIOServer;

    @GetMapping(value = "/send")
    public void send(@RequestParam(value = "event") String event,
                     @RequestParam(value = "data") String data) {
        socketIOServer.getBroadcastOperations().sendEvent(event, data);
    }
}
