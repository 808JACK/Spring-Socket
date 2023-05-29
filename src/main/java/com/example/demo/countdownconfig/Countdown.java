package com.example.demo.countdownconfig;

import com.example.demo.controller.CountdownWSController;
import com.example.demo.model.CountdownModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Countdown implements Runnable{

//    public Countdown(SimpMessagingTemplate template){
//        this.template = template;
//    }




    public Countdown(){

    }

    private static volatile int count=0;
    @Override
    public void run() {
        this.runTimer();

    }

    public void runTimer(){
        count=60;
        while(count>0){
            System.out.println("Countdown : "+count+" "+Thread.currentThread().getId());
            try{
                count--;
                Thread.sleep(1000);
                //sendCountdown(count);
//                try{
//                    this.template.convertAndSend("/topic/greetings", count);
//                }
//                catch(Exception e){
//                    System.out.println(e);
//                }
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }


    public int getCount(){
        return count;
    }

//    public void sendCountdown(int count){
//        this.template.convertAndSend("/topic/greetings", new CountdownModel(count));
//    }
}
