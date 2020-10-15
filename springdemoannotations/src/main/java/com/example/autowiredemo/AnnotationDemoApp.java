package com.example.autowiredemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAutoWire.xml");

        // --- 1. AutoWire on Constructor
//        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // --- 2. AutoWire on Setter/Method
        Coach basketballCoach = context.getBean("basketballCoach", Coach.class);
        System.out.println(basketballCoach.getDailyWorkout());
        System.out.println(basketballCoach.getDailyFortune());

        // --- 2. AutoWire on Fields / Property file
        SwimmingCoach swimmingCoach = context.getBean("swimmingCoach", SwimmingCoach.class);
        System.out.println(swimmingCoach.getDailyWorkout());
        System.out.println(swimmingCoach.getDailyFortune());
        System.out.println(swimmingCoach.getValuesFromPropertyFile());

        context.close();
    }
}
