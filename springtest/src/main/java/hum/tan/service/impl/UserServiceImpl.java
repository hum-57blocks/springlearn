package hum.tan.service.impl;

import hum.tan.dao.RoleDao;
import hum.tan.dao.UserDao;
import hum.tan.domain.Role;
import hum.tan.domain.User;
import hum.tan.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();

        // 封装userList中每个user的roles数据
        for (User user : userList) {
            // 获取user的id
            Long userId = user.getId();
            // 将userId作为参数，查询该userId对应的Role集合数据
            List<Role> roles = roleDao.findRolesByUserId(userId);

            user.setRoles(roles);
        }

        return userList;
    }

    @Override
    public void save(User user, List<Long> roleIds) {
        Long userId = userDao.save(user);
        userDao.saveUserRoleRel(userId, roleIds);
    }
}
