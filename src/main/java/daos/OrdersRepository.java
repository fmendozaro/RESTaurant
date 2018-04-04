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
        Query qry = session.createQuery("from Order where user.id = :userId");
        qry.setParameter("userId", userId);
        return qry.list();
    }

    @Override
    public Order findOne(Long id) {
        Query qry = session.createQuery("from Order where id = :id");
        qry.setParameter("id", id);
        return (Order) qry.getSingleResult();
    }

    @Override
    public Long insert(Order order) {
        // Save order
        session.save(order);
        return order.getId();
    }

}
