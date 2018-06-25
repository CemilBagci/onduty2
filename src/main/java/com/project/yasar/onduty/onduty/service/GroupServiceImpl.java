package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Group;
import com.project.yasar.onduty.onduty.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("groupService")
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;



    @Transactional(readOnly = false)
    @Override
    public Group createGroup(Group groups) {
        return groupRepository.save(groups);
    }

    @Override
    public Group findGroupByGroupNameEquals(String groupName) {
        return groupRepository.findGroupByGroupNameEquals(groupName);
    }
}
