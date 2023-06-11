package hum.tan.dao;

import hum.tan.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRolesByUserId(Long userId);
}
