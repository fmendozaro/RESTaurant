package daos;

import models.OrderItem;
import org.hibernate.Session;

import java.util.List;

public class OrderItemsRepository implements OrderItems {
    private final Session session;

    public OrderItemsRepository(Session session) {
        this.session = session;
    }

    @Override
    public List<OrderItem> all() {
        return null;
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        return null;
    }

    @Override
    public Long insert(OrderItem oi) {
        session.save(oi);
        return null;
    }
}
