package by.nagula.dao;

import by.nagula.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }

    @Override
    public List<User> showAllUser() {
        return null;
    }

    @Override
    public void updateUser(long id) {

    }

    @Override
    public boolean containsById(long id) {
        return false;
    }

    @Override
    public boolean containsByLogin(String login) {
        return false;
    }
}
