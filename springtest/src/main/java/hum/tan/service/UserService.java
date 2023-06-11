package hum.tan.service;

import hum.tan.domain.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void save(User user, List<Long> roleIds);

    void del(Long userId);
}
