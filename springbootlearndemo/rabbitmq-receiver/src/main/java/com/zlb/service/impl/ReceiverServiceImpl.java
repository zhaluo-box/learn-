package com.zlb.service.impl;

import com.zlb.service.ReceiverService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Override
    @RabbitListener(queues = "hello")
    public void receiverMsg(String msg) {
        System.out.println("接受消息---------------------------");
        System.out.println("接收到的消息 :" + msg);
    }
}
