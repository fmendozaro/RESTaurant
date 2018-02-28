package dao;

import models.Item;
import models.Order;

import java.util.List;

public interface Items {
    List<Item> all();
    Long insert(Item item);
}