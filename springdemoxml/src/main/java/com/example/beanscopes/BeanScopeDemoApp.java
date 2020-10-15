package com.example.beanscopes;

import com.example.dependencyInjectionDemo.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load the spring conriguration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanScopes.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if the are the same
        boolean result = (theCoach == alphaCoach);
        System.out.println("pointing to the smae object = " + result);
        System.out.println("Memory locaiton for theCoach" + theCoach);
        System.out.println("Memory location for alphaCoach" + alphaCoach);

        // close the context
        context.close();
    }
}
