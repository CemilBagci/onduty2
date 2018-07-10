package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service("dummyDataService")
@Transactional(readOnly = false)
public class DummyDataServiceImpl implements DummyDataService {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonalService personalService;

    @Autowired   // burda autowired yoktu? *melisa
    private DepartmentService departmentService;

    @Override
    public void createDummyData() {
        Role roleAdmin = roleService.findRoleByRoleNameEquals("ROLE_ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role("ROLE_ADMIN", State.ACTIVE, new ArrayList<>(Collections.singletonList(null)));
            roleAdmin = roleService.createRole(roleAdmin);
        }
        Role roleAdmin2 = roleService.findRoleByRoleNameEquals("ROLE_USER");
        if (roleAdmin2 == null) {
            roleAdmin2 = new Role("ROLE_USER", State.ACTIVE, new ArrayList<>(Collections.singletonList(null)));
            roleAdmin2 = roleService.createRole(roleAdmin2);
        }
        User user = userService.findUserByUsernameEquals("1");
        if (user == null) {
            user = new User("admin", "admin", "admin", new ArrayList<>(Collections.singletonList(roleAdmin)), "admin", "admin", State.ACTIVE);
            user = userService.createUser(user);
        }

        Personal personal = personalService.findPersonalByUser(user);

        if (personal == null) {
            personal = new Personal(user, new ArrayList<>(), new HashSet<>()); //doğru mu?
            personal = personalService.createPersonal(personal);
        }

        List<Department> all = departmentService.findAll();
        if (all.size() == 0) {
            Department department = new Department("Java Technologies");
            Department department2 = new Department("Mobile Technologies");
            Department department3 = new Department("Information Technologies");
            Department department4 = new Department("Human Resources");
            Department department5 = new Department("System and Network Security");
            Department department6 = new Department("Digital Technologies");
            Department department7 = new Department("ERP and SAP Technologies");

            departmentService.createDepartment(department);
            departmentService.createDepartment(department2);
            departmentService.createDepartment(department3);
            departmentService.createDepartment(department4);
            departmentService.createDepartment(department5);
            departmentService.createDepartment(department6);
            departmentService.createDepartment(department7);


        }


    }

}
	


