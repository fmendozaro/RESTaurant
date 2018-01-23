import java.util.ArrayList;
import java.util.List;

public class ListReservationsDao implements Reservations {
    private List<Reservation> reservations;

    public List<Reservation> all() {
        if (reservations == null) {
            reservations = generateAds();
        }
        return reservations;
    }

    private List<Reservation> generateAds() {
        List<Reservation> reservations = new ArrayList<>();

        reservations.add(new Reservation(
                1,
                1,
                2,
                "12-25-2018",
                "15:30:00"
        ));
        reservations.add(new Reservation(
                2,
                1,
                3,
                "02-15-2018",
                "08:59:00"
        ));
        reservations.add(new Reservation(
                3,
                2,
                4,
                "05-22-2018",
                "13:30:00"
        ));
        reservations.add(new Reservation(
                4,
                2,
                2,
                "06-14-2018",
                "21:30:00"
        ));
        return reservations;
    }
}
