package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    Department createDepartment(Department department);
    Department findDepartmentByDepartmentName(String departmentName);

}
