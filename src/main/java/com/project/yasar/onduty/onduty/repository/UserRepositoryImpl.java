package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.User;


public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findUserByUsernameEquals(String username) {
        return null;
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> ıterable) {
        return null;
    }

    @Override
    public User findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAll(Iterable<Long> ıterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(Iterable<? extends User> ıterable) {

    }

    @Override
    public void deleteAll() {

    }
}
