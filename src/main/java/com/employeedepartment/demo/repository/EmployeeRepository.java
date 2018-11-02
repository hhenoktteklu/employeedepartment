package com.employeedepartment.demo.repository;

import com.employeedepartment.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}
