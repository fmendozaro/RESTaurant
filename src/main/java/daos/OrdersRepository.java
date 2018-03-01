package daos;


import models.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class OrdersRepository implements daos.Orders {

    private final Session session;

    public OrdersRepository(Session session) {
        this.session = session;
    }


    @Override
    public List<Order> all() {
        Query qry = session.createQuery("from Order");
        return qry.list();
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        Query qry = session.createQuery("from Order where user.id = ?");
        qry.setParameter(0, userId);
        return qry.list();
    }

    @Override
    public Long insert(Order order) {
        session.save(order);
        return order.getId();
    }
}
