package ru.kviak.hibenate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kviak.hibenate.model.Person;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.createMutationQuery("delete from Person where age<20")
                    .executeUpdate();

            session.getTransaction().commit();

//            System.out.println(person1.getId());
        } finally {
            sessionFactory.close();
        }
    }
}