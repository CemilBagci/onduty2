package com.project.yasar.onduty.onduty.service;


import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    
    @Override 
    public User findUserByUsername(String username) {
    	return userRepository.findByUsername(username);
    }
    
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
