package com.loginlogout.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginlogout.web.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
