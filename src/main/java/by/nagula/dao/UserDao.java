package by.nagula.dao;

import by.nagula.entity.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    void deleteUser(long id);
    List<User> showAllUser();
    void updateUser(long id);
    boolean containsById(long id);
    boolean containsByLogin(String login);
}
