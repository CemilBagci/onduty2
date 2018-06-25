package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("groupRepository")

public interface GroupRepository extends CrudRepository<Group,Long> {
    Group findGroupByGroupNameEquals(String groupName);

}
