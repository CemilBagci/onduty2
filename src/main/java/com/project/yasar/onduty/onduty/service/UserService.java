package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);
    User findUserByUsernameEquals(String username);
     List<User> findAll();
}
