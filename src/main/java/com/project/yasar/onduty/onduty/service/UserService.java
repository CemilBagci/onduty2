package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.viewmodel.UserRegister;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);
    User findUserByUsernameEquals(String username);
    List<User> findAll();
    Boolean delete(Long id);
    User get(Long id);
	void saveUser(UserRegister userRegister);
}
