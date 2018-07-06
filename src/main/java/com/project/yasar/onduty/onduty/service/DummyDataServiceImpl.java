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

        User user2 = userService.findUserByUsernameEquals("2");
        if (user2 == null) {
            user2 = new User("2", "2", "2", new ArrayList<>(Collections.singletonList(roleAdmin)), "2", "2", State.ACTIVE);
            user2 = userService.createUser(user2);
        }
        User user3 = userService.findUserByUsernameEquals("3");
        if (user3 == null) {
            user3 = new User("3", "3", "3", new ArrayList<>(Collections.singletonList(roleAdmin)), "3", "3", State.ACTIVE);
            user3 = userService.createUser(user3);
        }


        List<Department> all = departmentService.findAll();
        if (all.size() < 9) {
            Department department = new Department("office");
            Department department2 = new Department("office");
            departmentService.createDepartment(department);
            departmentService.createDepartment(department2);
            Personal personal = personalService.findPersonalByUser(user);
            Personal personal2= personalService.findPersonalByUser(user2);
            Personal personal3= personalService.findPersonalByUser(user3);
            List<Department> departments = new ArrayList<>();
            Set<Project> projects = new HashSet<>();
            departments.add(department);
            departments.add(department2);
            if (personal == null) {
                personal = new Personal(user, departments, projects); //doğru mu?
                personal = personalService.createPersonal(personal);
            }
            if(personal2 == null){
                personal2 =  new Personal(user2,departments,projects);
                personal2 = personalService.createPersonal(personal2);

            }
            if(personal3 == null){
                personal3 =  new Personal(user3,departments,projects);
                personal3 = personalService.createPersonal(personal3);

            }

        }


    }

}
	


