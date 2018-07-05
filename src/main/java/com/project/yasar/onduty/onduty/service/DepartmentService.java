package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.domain.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department createDepartment(Department department);
    Department findDepartmentByDepartmentName(String departmentName);

    List<Department> findAll();
}
