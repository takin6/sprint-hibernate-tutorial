package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try {
            int studentId=1;
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting Student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby");

            // commit transaction
            session.getTransaction().commit();

            // --------------------------------------------
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\n\nUpdate email for all students");
            session.createQuery("update Student set email='foo@email.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            factory.close();
        }
    }
}
