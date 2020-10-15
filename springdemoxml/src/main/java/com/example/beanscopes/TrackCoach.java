package com.example.beanscopes;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyworkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just Do It: " + fortuneService.getFortune();
    }

    public void doMyStartUpStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    public void doMyCleanUpStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }
}
