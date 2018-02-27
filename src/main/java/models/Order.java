package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(nullable = false)
    private Date deliveryTime;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal tax;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal tip;

    @Column(nullable = false, precision=10, scale=2)
    private BigDecimal total;

    @ManyToOne
    private User user;

    public Order(){}

    public Order(Date orderDate, Date deliveryTime, BigDecimal subtotal, BigDecimal tax, BigDecimal tip, BigDecimal total, User user) {
        this.orderDate = orderDate;
        this.deliveryTime = deliveryTime;
        this.subtotal = subtotal;
        this.tax = tax;
        this.tip = tip;
        this.total = total;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
