package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Role;
import com.project.yasar.onduty.onduty.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findUserByRole(List<Role> roles) {

        return roleRepository.findByRole( roles);
    }
}

