package com.example.autowiredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {
    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimmingCoach() {
        System.out.println(">> SwimmingCoach: inside default constructor");
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backstroke!!";
    }

    public String getValuesFromPropertyFile() {
        return email + " " + team;
    }
}
