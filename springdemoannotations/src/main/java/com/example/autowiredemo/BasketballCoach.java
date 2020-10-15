package com.example.autowiredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
    private FortuneService fortuneService;

    public BasketballCoach() {
        System.out.println(">> BasketBallCoach: inside default constructor");
    }

    //    @Autowired
//    public void setFortuneService(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }

    @Autowired
    @Qualifier("RESTFortuneService")
    public void doSomething(FortuneService theFortuneService) {
        System.out.println(">> BasketBallCoach: inside doSomething!!!");
        fortuneService = theFortuneService;
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your 3 pointer!!";
    }
}
