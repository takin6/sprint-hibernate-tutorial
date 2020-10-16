package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create Session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(theStudents);

            // query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("\n\n\n");
            displayStudents(theStudents);

            // query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Duffy'").getResultList();
            System.out.println("\n\n\n");
            displayStudents(theStudents);

            // query students: endswith example.com'
            theStudents = session.createQuery("from Student s where s.email LIKE '%example.com'").getResultList();
            System.out.println("\n\n\n");
            displayStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
