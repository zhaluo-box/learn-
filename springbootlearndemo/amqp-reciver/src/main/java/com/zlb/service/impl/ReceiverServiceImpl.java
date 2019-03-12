package com.zlb.service.impl;

import com.zlb.service.ReceiverService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void receiverMsg(String msg) {

        for (int i = 0; i <10 ; i++) {
            rabbitTemplate.convertAndSend("hello",msg+"-- ("+i+" )---"+new Date());
        }
    }
}
