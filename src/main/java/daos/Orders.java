package daos;

import models.Order;
import java.util.List;

public interface Orders {
    List<Order> all();
    List<Order> findByUserId(Long userId);
    Long insert(Order rsv);
}