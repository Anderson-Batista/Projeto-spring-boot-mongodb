package com.andersonbatista.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonbatista.projetomongo.domain.User;
import com.andersonbatista.projetomongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll(); // vai no banco de dados e retorna todos os dados de USER
	}
	
}
