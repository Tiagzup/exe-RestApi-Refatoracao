package com.br.spring.relacional.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.spring.relacional.models.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {

}
