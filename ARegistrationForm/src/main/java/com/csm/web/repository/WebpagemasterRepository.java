package com.csm.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csm.web.entity.WebpagemasterEntity;
@Repository
public interface WebpagemasterRepository extends CrudRepository<WebpagemasterEntity, Integer> {

}
