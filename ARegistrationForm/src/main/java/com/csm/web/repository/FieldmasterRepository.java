package com.csm.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csm.web.entity.FieldmasterEntity;
@Repository
public interface FieldmasterRepository extends CrudRepository<FieldmasterEntity, Integer> {

}
