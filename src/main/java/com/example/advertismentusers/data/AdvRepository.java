package com.example.advertismentusers.data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AdvRepository {
    private static SessionFactory factory;

    public AdvRepository() {
        try {
            factory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Advertisment.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<Advertisment> getAdvertisments() {
        var session = factory.openSession();

        try {
            return session.createQuery("FROM Advertisment").list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return new ArrayList<>();
    }

    public Advertisment getById(int id) {
        var session = factory.openSession();

        try {
            return session.get(Advertisment.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return null;
    }
}
