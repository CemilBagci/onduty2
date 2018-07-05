package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.repository.GroupRepository;
import com.project.yasar.onduty.onduty.repository.PersonalRepository;
import com.project.yasar.onduty.onduty.repository.ProjectRepository;

import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Service("dummyDataService")
@Transactional(readOnly = false)
public class DummyDataServiceImpl implements DummyDataService {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired   // burda autowired yoktu? *melisa
    private DepartmentService departmentService;


    @Override
    public void createDummyData() {
        Role roleAdmin = roleService.findRoleByRoleNameEquals("ROLE_ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role("ROLE_ADMIN", State.ACTIVE, new ArrayList<>(Collections.singletonList(null)));
            roleAdmin = roleService.createRole(roleAdmin);
        }
        User user = userService.findUserByUsernameEquals("1");
        if (user == null) {
            user = new User("1", "1", "1", new ArrayList<>(Collections.singletonList(roleAdmin)), "1", "1", State.ACTIVE);
            user = userService.createUser(user);
        }


        List<Department> all = departmentService.findAll();
        if (all.size() < 2) {
            Department department = new Department("office");
            Department department2 = new Department("office");
            departmentService.createDepartment(department);
            departmentService.createDepartment(department2);
            Personal personal = personalService.findPersonalByUser(user);
            List<Department> departments = new ArrayList<>();
            Set<Project> projects = new HashSet<>();
            departments.add(department);
            departments.add(department2);
            if (personal == null) {
                personal = new Personal(user, departments, projects); //doğru mu?
                personal = personalService.createPersonal(personal);
            }
        }


    }

}
	


