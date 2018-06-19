package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public User findUserByUsername(String username);
    User createUser(User user);
}
