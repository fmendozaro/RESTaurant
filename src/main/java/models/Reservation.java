package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int num_people;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Date time;

    @ManyToOne
    private User user;

    public Reservation() {
    }

    public Reservation(long id, User user, int num_people, Date date, Date time) {
        this.id = id;
        this.user = user;
        this.num_people = num_people;
        this.date = date;
        this.time = time;
    }

    public Reservation(User user, int num_people, Date date, Date time) {
        this.user = user;
        this.num_people = num_people;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum_people() {
        return num_people;
    }

    public void setNum_people(int num_people) {
        this.num_people = num_people;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
