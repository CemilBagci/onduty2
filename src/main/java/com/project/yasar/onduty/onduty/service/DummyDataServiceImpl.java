package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.*;
import com.project.yasar.onduty.onduty.repository.GroupRepository;
import com.project.yasar.onduty.onduty.repository.PersonalRepository;
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
    private GroupRepository groupRepository;
    @Autowired
    private PersonalRepository personalRepository;
    @Autowired
    private DepartmentService departmentService;
    @Override
    public void createDummyData() {
        Role roleAdmin = roleService.findRoleByRoleNameEquals("ROLE_ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role("ROLE_ADMIN", State.ACTIVE, Collections.singletonList(null));
            roleAdmin = roleService.createRole(roleAdmin);
        }
        User user = userService.findUserByUsernameEquals("1");
        if (user == null) {
            user = new User("1", "1", "1", Collections.singletonList(roleAdmin), "1", "1", State.ACTIVE);
            user = userService.createUser(user);
        }
        Department department =new Department("officeeee");
        departmentService.createDepartment(department);
        Personal personal = personalService.findPersonalByUser(user);
        if(personal ==null) {
            personal = new Personal(user, null, new ArrayList<>(), Arrays.asList(department));
            personal = personalService.createPersonal(personal);
        }
        if (personal.getGroups().size()<10) {
            Group group =new Group("group"+new Random().nextInt(50));
            groupRepository.save(group);
            personal.getGroups().add(group);
            personalRepository.save(personal);
        }
        Task task = new Task("a", TaskStateType.ACTIVE, "ali", TaskPriority.high, null, null, null);
         task = taskService.createTask(task);
         personal.getTasks().add(task);
         personalRepository.save(personal); 
        
    }
}
