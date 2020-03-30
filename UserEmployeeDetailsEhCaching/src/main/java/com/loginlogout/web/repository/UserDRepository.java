package com.loginlogout.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginlogout.web.entity.UserD;

public interface UserDRepository extends JpaRepository<UserD, Integer> {
	UserD findByUsernameAndPassword(String username,String password);
	

}
