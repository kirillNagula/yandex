package by.nagula.dao;

import by.nagula.entity.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    boolean containsById(long id);
    boolean containsByLogin(String login);
    User showUser(String login);
}
