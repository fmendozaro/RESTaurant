package models;

import javax.persistence.*;

@Entity
@Table(name = "orders_items")
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Item item;

    @Column(nullable = false)
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Order order, Item item, int quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
