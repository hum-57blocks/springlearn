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
}
