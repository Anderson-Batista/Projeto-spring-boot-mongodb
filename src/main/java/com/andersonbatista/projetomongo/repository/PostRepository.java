package com.andersonbatista.projetomongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.andersonbatista.projetomongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{	
	
	// montando consultas com QueryMethods
	List<Post> findByTitleContainingIgnoreCase(String text);// consulta simples
	
	// Consulta com regex Query methods
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	@Query("{ $and: [ { date: { $gte: ?1} }, { date: { $lte: ?2}}, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
