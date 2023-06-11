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
}
