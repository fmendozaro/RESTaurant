package dao;

public class DaoFactory {
    private static Reservations reservationsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Reservations getReservationsDao() {
        if (reservationsDao == null) {
            reservationsDao = new MySQLRsvDao(config);
        }
        return reservationsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}