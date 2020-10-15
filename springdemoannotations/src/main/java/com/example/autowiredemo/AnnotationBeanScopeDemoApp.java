package com.example.autowiredemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAutoWire.xml");

        // --- 1. AutoWire on Constructor
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);
        System.out.println("Pointing to the same object: " + result);
        System.out.println(theCoach);
        System.out.println(alphaCoach);

        context.close();
    }
}
