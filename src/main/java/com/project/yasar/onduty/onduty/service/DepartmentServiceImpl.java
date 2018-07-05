package com.project.yasar.onduty.onduty.service;

import com.project.yasar.onduty.onduty.ContextUtil;
import com.project.yasar.onduty.onduty.domain.Department;
import com.project.yasar.onduty.onduty.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;
import java.util.List;

@Service("departmentService")
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    @Transactional(readOnly = false)
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentByDepartmentName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentName(departmentName);
    }

    @Override
    public List<Department> findAll() {
        return ContextUtil.toList(departmentRepository.findAll());
    }
}
