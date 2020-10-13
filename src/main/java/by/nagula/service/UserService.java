package by.nagula.service;


import by.nagula.entity.User;

public interface UserService {

    void createUser(User user);
    User showUser(String login);
    boolean containsUser(String login);

}
