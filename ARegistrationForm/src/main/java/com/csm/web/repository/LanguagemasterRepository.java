package com.csm.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csm.web.entity.LanguagemasterEntity;
@Repository
public interface LanguagemasterRepository extends CrudRepository<LanguagemasterEntity, Integer> {

}
