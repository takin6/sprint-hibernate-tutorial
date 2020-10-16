package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            Student tempStudent = new Student("Duffy", "Duck", "duffy@example.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // -----------------------------------------------------------------------------------------------
            // get a new session and start transaction (in hibernate world, queries also require transactions)
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
