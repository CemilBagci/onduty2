package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Group;
import org.springframework.stereotype.Service;

@Service

public interface GroupService {
    Group createGroup(Group groups);
    Group findGroupByGroupNameEquals(String groupName);
}
