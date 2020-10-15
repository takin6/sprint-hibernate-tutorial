package com.example.beanscopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
    public static void main(String[] args) {
        // load the spring conriguration
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanLifecycle.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // check if the are the same
        System.out.println(theCoach.getDailyworkout());

        // close the context
        context.close();
    }
}
