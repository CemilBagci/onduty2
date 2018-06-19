package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
	Role createRole(Role role);
	Role findRoleByRoleNameEquals(String roleName);
}
