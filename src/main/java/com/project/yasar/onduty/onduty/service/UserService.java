package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);
    User findUserByUsernameEquals(String username);
}
