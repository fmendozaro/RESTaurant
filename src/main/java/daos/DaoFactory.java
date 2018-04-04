package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DaoFactory {

    private static Reservations reservationsDao;
    private static Users usersDao;
    private static Orders ordersDao;
    private static Items itemsDao;
    private static OrderItems orderItems;
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

    public static Reservations getReservationsDao() {
        if (reservationsDao == null) {
            reservationsDao = new ReservationsRepository(openSession());
        }
        return reservationsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new UsersRepository(openSession());
        }
        return usersDao;
    }

    public static Orders getOrdersDao() {
        if(ordersDao == null){
            ordersDao = new OrdersRepository(openSession());
        }
        return ordersDao;
    }

    public static Items getItemsDao() {
        if(itemsDao == null){
            itemsDao = new ItemsRepository(openSession());
        }
        return itemsDao;
    }

    public static OrderItems getorderItemsDao() {
        if(orderItems == null){
            orderItems = new OrderItemsRepository(openSession());
        }
        return orderItems;
    }
}