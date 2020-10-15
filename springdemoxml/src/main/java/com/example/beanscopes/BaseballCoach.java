package com.example.beanscopes;

public class BaseballCoach implements Coach {
    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for depency injection
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyworkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
