package hum.tan.dao.impl;

import hum.tan.dao.UserDao;
import hum.tan.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

        List<User> userList = jdbcTemplate.query("select * from `sys_user`", rowMapper);

        return userList;
    }

    @Override
    public Long save(User user) {
        jdbcTemplate.update("insert into `sys_user` values (?, ?, ?, ?, ?)", null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return null;
    }

    @Override
    public void saveUserRoleRel(Long userId, List<Long> roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into `sys_user_role` values (?, ?)", userId, roleId);
        }
    }
}
