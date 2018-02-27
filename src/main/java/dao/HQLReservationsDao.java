package dao;


import models.Reservation;
import models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class HQLReservationsDao implements Reservations {

    private final Session session;

    public HQLReservationsDao(Session session) {
        this.session = session;
    }


    @Override
    public List<Reservation> all() {
        Query qry = session.createQuery("from Reservation");
        return qry.list();
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        Query qry = session.createQuery("from Reservation where user.id = ?");
        qry.setParameter(0, userId);
        return qry.list();
    }

    @Override
    public Long insert(Reservation rsv) {
        session.save(rsv);
        return rsv.getId();
    }
}
