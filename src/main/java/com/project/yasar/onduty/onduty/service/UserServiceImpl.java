package com.project.yasar.onduty.onduty.service;


import com.project.yasar.onduty.onduty.domain.User;
import com.project.yasar.onduty.onduty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
            userRepository.delete(user);

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


}

