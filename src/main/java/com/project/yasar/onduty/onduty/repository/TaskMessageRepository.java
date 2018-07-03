package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Personal;
import com.project.yasar.onduty.onduty.domain.TaskMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskMessageRepository")
public interface TaskMessageRepository extends CrudRepository<TaskMessage, Long> {
    List<TaskMessage> findByPersonal(Personal personal);

}
