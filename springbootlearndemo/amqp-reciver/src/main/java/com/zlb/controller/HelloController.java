package com.zlb.controller;

import com.zlb.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ReceiverService service;

    @PostMapping("/send/{msg}")
    public void sendMsg(@PathVariable String msg){

        System.out.println("------msg" + msg);
        System.out.println("_----------------消息已发送");
        service.receiverMsg(msg);
    }
}
