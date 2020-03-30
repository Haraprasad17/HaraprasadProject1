package com.loginlogout.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.loginlogout.web.entity.Employee;
import com.loginlogout.web.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository erepo;

	@CacheEvict(value="twenty-second-cache", 
			condition = "#isCacheable == null || !#isCacheable", beforeInvocation = true)
	@Cacheable(value="twenty-second-cache", key = "'StudentInCache'+#studentId",condition = "#isCacheable != null && #isCacheable")
	public List<Employee> fetchEmployee( boolean isCacheable) throws InterruptedException {
		Thread.sleep(4000);
		System.err.println("------------------------------------------------------>databasehit");
		return erepo.findAll();
		
		
	}

}
