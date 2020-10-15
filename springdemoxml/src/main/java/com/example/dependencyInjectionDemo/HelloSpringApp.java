package com.example.dependencyInjectionDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // load the spring conriguration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDI.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("MyCoach", Coach.class);
        // call methods on the bean
        System.out.println(theCoach.getDailyworkout());
        System.out.println(theCoach.getDailyFortune());

        Coach golfCoach = context.getBean("GolfCoach", Coach.class);
        System.out.println(golfCoach.getDailyworkout());
        System.out.println(golfCoach.getDailyFortune());
        System.out.println(golfCoach.getDailyFortune());
        System.out.println(golfCoach.getDailyFortune());

        // close the context
        context.close();

    }
}
