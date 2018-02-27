package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static Session openSession() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build()
                ;

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        return sessionFactory.openSession();
    }

}
