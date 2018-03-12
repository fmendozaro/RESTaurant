package daos;


import models.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class ReservationsRepository implements Reservations {

    private final Session session;

    public ReservationsRepository(Session session) {
        this.session = session;
    }


    @Override
    public List<Reservation> all() {
        Query qry = session.createQuery("from Reservation");
        return qry.list();
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        Query qry = session.createQuery("from Reservation where user.id = :userId");
        qry.setParameter("userId", userId);
        return qry.list();
    }

    @Override
    public Long insert(Reservation rsv) {
        session.save(rsv);
        return rsv.getId();
    }
}
