package com.example.demo;

import com.example.demo.countdownconfig.Countdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) {
//		Thread th = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				for(int i=60;i>=0;i--){
//
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						throw new RuntimeException(e);
//					}
//					System.out.println("Countdown : "+i);
//				}
//			}
//		});

//		System.out.println("Starting the countdown");
//		int i=0;
//		while(i>0){
//			System.out.println("Countdown : "+i+" "+Thread.currentThread().getId());
//			try{
//				i--;
//				Thread.sleep(1000);
//			}
//			catch (InterruptedException e){
//				System.out.println(e);
//			}
//		}
		SpringApplication.run(DemoApplication.class, args);
		Thread th = new Thread(new Countdown());
		th.start();

	}

}
