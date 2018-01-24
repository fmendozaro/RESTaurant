package dao;

public class DaoFactory {
    private static Reservations reservationsDao;
    private static Config config = new Config();

    public static Reservations getReservationsDao() {
        if (reservationsDao == null) {
            reservationsDao = new MySQLRsvDao(config);
        }
        return reservationsDao;
    }
}