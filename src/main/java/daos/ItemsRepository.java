package daos;


import models.Item;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

@SuppressWarnings("unchecked")
public class ItemsRepository implements Items {

    private final Session session;

    public ItemsRepository(Session session) {
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
