package com.example.demo.controller;

import com.example.demo.countdownconfig.Countdown;
import com.example.demo.model.CountdownModel;
import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class CountdownWSController {

    private Countdown countdown;
    private SimpMessagingTemplate template;


    public CountdownWSController(Countdown cnt, SimpMessagingTemplate template){
        this.template = template;
        countdown = cnt;
    }
    //The return value is broadcast to all subscribers of /topic/greetings, as specified in the @SendTo annotation.
    //The @MessageMapping annotation ensures that, if a message is sent to the /hello destination, the greeting() method is called.
//    @MessageMapping("/client")
//    @SendTo("/topic/greetings")
//    public int countdownSent() throws Exception{
//        //Thread.sleep(1000);
//        System.out.println(countdown.getCount());
//
//    }

//    @Autowired
//    public CountdownWSController(SimpMessagingTemplate template){
//        this.template = template;
//    }

    @CrossOrigin
    @MessageMapping("/client")
    @SendTo("/topic/greetings")
    public void helloServer(Message message) throws Exception{
//        System.out.println(countdown.getCount());
//        System.out.println(message.getMessage()+" Here ");
        for(int i=0;i<5;i++)
            this.template.convertAndSend("/topic/greetings", new CountdownModel(countdown.getCount()));
    }
}
