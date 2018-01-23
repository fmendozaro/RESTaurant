public class DaoFactory {
    private static Reservations reservationsDao;

    public static Reservations getReservationsDao() {
        if (reservationsDao == null) {
            reservationsDao = new ListReservationsDao();
        }
        return reservationsDao;
    }
}
