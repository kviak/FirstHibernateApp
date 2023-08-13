package ru.kviak.hibenate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kviak.hibenate.model.Item;
import ru.kviak.hibenate.model.Person;


public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}