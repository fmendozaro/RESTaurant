package dao;


import models.Item;
import models.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class HQLItemsDao implements Items {

    private final Session session;

    public HQLItemsDao(Session session) {
        this.session = session;
    }


    @Override
    public List<Item> all() {
        Query qry = session.createQuery("from Item");
        return qry.list();
    }

    @Override
    public Long insert(Item item) {
        session.save(item);
        return item.getId();
    }
}
