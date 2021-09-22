package com.example.mycustomerproducer.controller;

import com.example.mycustomerproducer.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/api")
public class MessageController {

    private Queue queue;

    private JmsTemplate jmsTemplate;

    @Autowired
    public MessageController(Queue queue, JmsTemplate jmsTemplate) {
        this.queue = queue;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/customers")
    public ResponseEntity<String> publish(@RequestBody final CustomerModel customerModel){
        jmsTemplate.convertAndSend(queue, customerModel.toString());
        return new ResponseEntity("pushed to activemq", HttpStatus.OK);
    }

}
