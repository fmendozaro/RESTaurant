public class DaoFactory {
    private static Reservations reservationsDao;

    public static Reservations getReservationsDao() {
        if (reservationsDao == null) {
            reservationsDao = new MySQLRsvDao();
        }
        return reservationsDao;
    }
}