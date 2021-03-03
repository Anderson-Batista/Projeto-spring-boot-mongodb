package com.andersonbatista.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andersonbatista.projetomongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
}
