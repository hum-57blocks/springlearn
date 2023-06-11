package hum.tan.dao;

import hum.tan.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, List<Long> roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);
}
