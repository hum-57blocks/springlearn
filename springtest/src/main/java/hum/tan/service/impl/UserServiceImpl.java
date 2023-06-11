package hum.tan.service.impl;

import hum.tan.dao.UserDao;
import hum.tan.domain.User;
import hum.tan.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        return userList;
    }
}
