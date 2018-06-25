package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("departmentRepository")
public interface DepartmentRepository extends CrudRepository<Department,Long> {
    Department findDepartmentByDepartmentName(String departmentName);
}
