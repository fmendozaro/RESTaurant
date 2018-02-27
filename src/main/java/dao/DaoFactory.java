package dao;

import org.hibernate.Session;
import utils.HibernateUtil;

public class DaoFactory {
    private static Reservations reservationsDao;
    private static Users usersDao;
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
}