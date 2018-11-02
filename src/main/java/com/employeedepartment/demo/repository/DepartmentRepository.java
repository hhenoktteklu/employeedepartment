package com.employeedepartment.demo.repository;

import com.employeedepartment.demo.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
