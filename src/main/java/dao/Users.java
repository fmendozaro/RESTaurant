package dao;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
}