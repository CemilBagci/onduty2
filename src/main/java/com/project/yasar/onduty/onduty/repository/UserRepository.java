package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User,Long> {
}
