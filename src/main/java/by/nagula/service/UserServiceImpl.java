package by.nagula.service;

import by.nagula.dao.UserDaoImpl;
import by.nagula.entity.User;
import by.nagula.exception.EmptyDateInLogin;
import by.nagula.exception.EmptyUserException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        if (user != null){
            userDao.createUser(user);
        } else {
            throw new EmptyUserException();
        }
    }

    @Override
    public User showUser(String login) {
        if (!login.isEmpty()){
            return userDao.showUser(login);
        } else {
            throw new EmptyDateInLogin();
        }
    }

    @Override
    public boolean containsUser(String login) {
        if (!login.isEmpty()){
            return userDao.containsByLogin(login);
        } else {
            return false;
        }

    }
}
