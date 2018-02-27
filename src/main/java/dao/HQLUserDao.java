package dao;


import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HQLUserDao implements Users {

    private final Session session;

    public HQLUserDao(Session session) {
        this.session = session;
    }

    @Override
    public User findByUsername(String username) {
        Query qry = session.createQuery("from User where username = ?");
        qry.setParameter(0, username);
        return (User) qry.uniqueResult();
    }

    @Override
    public Long insert(User user) {
        session.save(user);
        return user.getId();
    }

}
