package com.project.yasar.onduty.onduty.service;


import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.Role;
import com.project.yasar.onduty.onduty.domain.State;
import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.repository.RoleRepository;
import com.project.yasar.onduty.onduty.repository.UserRepository;
import com.project.yasar.onduty.onduty.viewmodel.UserRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PersonalService personalService;
    
    @Autowired
    private RoleRepository roleService;

    @Override
    @Transactional(readOnly = false)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsernameEquals(String username) {
        return userRepository.findUserByUsernameEquals(username);
    }

    @Override
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = false)
    public Boolean delete(Long id) {
        try {
            User user = userRepository.findOne(id);
            user.setState(State.PASSIVE);
            userRepository.save(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User get(Long id) {
        return userRepository.findOne(id);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void saveUser(UserRegister userRegister)  {
    	
    	User user = new User(userRegister.getName(), userRegister.getSurname()
        		, userRegister.getEmail(), new ArrayList<>(), userRegister.getUsername()
        		, userRegister.getPassword(), userRegister.getState());
        
        Role roleUser = roleService.findRoleByRoleNameEquals("ROLE_USER");
        user.setRoles(new ArrayList<>(Arrays.asList(roleUser)));
        
        user = createUser(user);
        Personal personal = new Personal(user, userRegister.getDepartments(), new HashSet<>());
        personalService.createPersonal(personal);
    }


}

