import java.util.List;

public interface Reservations {
    List<Reservation> all();
    Long insert(Reservation rsv);
}