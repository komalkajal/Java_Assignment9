package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentCRUD {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            // CREATE
            session.beginTransaction();
            Student s1 = new Student("Komal Kajal", "CSE");
            session.save(s1);
            session.getTransaction().commit();

            // READ
            session = factory.openSession();
            Student fetched = session.get(Student.class, s1.getId());
            System.out.println("Fetched: " + fetched.getName());

            // UPDATE
            session.beginTransaction();
            fetched.setCourse("Spring Boot");
            session.update(fetched);
            session.getTransaction().commit();

            // DELETE
            session.beginTransaction();
            session.delete(fetched);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
