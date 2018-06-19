package com.project.yasar.onduty.onduty.repository;

import org.springframework.stereotype.Repository;
import com.project.yasar.onduty.onduty.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findRoleByRoleNameEquals(String roleName);

}
