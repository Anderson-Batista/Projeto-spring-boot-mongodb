package com.andersonbatista.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andersonbatista.projetomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	
}
