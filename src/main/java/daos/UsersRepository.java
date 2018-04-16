package daos;


import models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsersRepository implements Users {

    private final Session session;

    public UsersRepository(Session session) {
        this.session = session;
    }

    @Override
    public User findByUsername(String username) {
        Query qry = session.createQuery("from User where username = :username");
        qry.setParameter("username", username);
        return (User) qry.uniqueResult();
    }

    @Override
    public Long save(User user) {
        session.beginTransaction();
            session.saveOrUpdate(user);
        session.getTransaction().commit();
        return user.getId();
    }

    @Override
    public User findById(long id) {
        Query qry = session.createQuery("from User where id = :id");
        qry.setParameter("id", id);
        return (User) qry.uniqueResult();
    }

}
