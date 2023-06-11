package hum.tan.dao.impl;

import hum.tan.dao.RoleDao;
import hum.tan.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        RowMapper<Role> rowMapper = new BeanPropertyRowMapper<>(Role.class);
        List<Role> roleList = jdbcTemplate.query("select * from `sys_role`", rowMapper);
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into `sys_role` values (?, ?, ?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRolesByUserId(Long userId) {
        RowMapper<Role> rowMapper = new BeanPropertyRowMapper<>(Role.class);
        List<Role> roles = jdbcTemplate.query("select * from `sys_user_role` ur, `sys_role` r where ur.`roleId`=r.`id` and ur.`userId`=?", rowMapper, userId);
        return roles;
    }
}
