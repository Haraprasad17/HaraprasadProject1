package com.loginlogout.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loginlogout.web.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	
  // this is the call of a store procedure
	@Query(value = "call customers_order();", nativeQuery = true)
	List<Object> findcustomersorder();
	
}
