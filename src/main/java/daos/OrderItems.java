package daos;

import models.OrderItem;

import java.util.List;

public interface OrderItems {
    List<OrderItem> all();
    List<OrderItem> findByOrderId(Long orderId);
    Long insert(OrderItem oi);
}