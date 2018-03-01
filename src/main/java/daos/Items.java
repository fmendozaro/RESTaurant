package daos;

import models.Item;

import java.util.List;

public interface Items {
    List<Item> all();
    Long insert(Item item);
}