package daos;

import models.User;

public interface Users {
    User findByUsername(String username);
    Long save(User user);
    User findById(long id);
}