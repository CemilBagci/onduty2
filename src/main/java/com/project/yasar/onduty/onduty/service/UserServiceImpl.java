package com.project.yasar.onduty.onduty.service;


import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsernameEquals(String username) {
        return userRepository.findUserByUsernameEquals(username);
    }


}

