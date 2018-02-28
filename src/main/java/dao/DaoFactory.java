package dao;

import org.hibernate.Session;
import utils.HibernateUtil;

public class DaoFactory {
    private static Reservations reservationsDao;
    private static Users usersDao;
    private static Orders ordersDao;
    private static Items itemsDao;
    private static Session session = HibernateUtil.openSession();

    public static Reservations getReservationsDao() {
        if (reservationsDao == null) {
            reservationsDao = new HQLReservationsDao(session);
        }
        return reservationsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new HQLUserDao(session);
        }
        return usersDao;
    }

    public static Orders getOrdersDao() {
        if(ordersDao == null){
            ordersDao = new HQLOrdersDao(session);
        }
        return ordersDao;
    }

    public static Items getItemsDao() {
        if(itemsDao == null){
            itemsDao = new HQLItemsDao(session);
        }
        return itemsDao;
    }
}