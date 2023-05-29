package com.example.demo.controller;


import com.example.demo.countdownconfig.Countdown;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountdownRestController {

    Countdown countdown;

    public CountdownRestController(Countdown cnt){
        countdown = cnt;
    }

    @GetMapping("/countdown")
    public int getCountdown(){
        return countdown.getCount();
    }
}
