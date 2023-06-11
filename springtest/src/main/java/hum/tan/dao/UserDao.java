package hum.tan.dao;

import hum.tan.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
