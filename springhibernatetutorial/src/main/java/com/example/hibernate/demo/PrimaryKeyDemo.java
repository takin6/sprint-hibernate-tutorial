package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create Session
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save Java object
            // Create a student object
            System.out.println("Creating new student object...");
            Student tempStudent1 = new Student("John", "Doe", "john@example.com");
            Student tempStudent2 = new Student("Mary", "Pubic", "mary@example.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@example.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
