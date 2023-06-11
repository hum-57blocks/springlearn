package hum.tan.dao.impl;

import hum.tan.dao.UserDao;
import hum.tan.domain.User;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
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
        // 创建PreparedStatementCreator
        PreparedStatementCreator creator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement("insert into `sys_user` values (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNum());
            return preparedStatement;
        };

        // 创建KeyHolder
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, keyHolder);

        // 获取生成的主键ID
        Long userId = keyHolder.getKey().longValue();

        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, List<Long> roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into `sys_user_role` values (?, ?)", userId, roleId);
        }
    }
}
