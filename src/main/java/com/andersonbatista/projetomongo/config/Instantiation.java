package com.andersonbatista.projetomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andersonbatista.projetomongo.domain.Post;
import com.andersonbatista.projetomongo.domain.User;
import com.andersonbatista.projetomongo.dto.AuthorDTO;
import com.andersonbatista.projetomongo.dto.CommentDTO;
import com.andersonbatista.projetomongo.repository.PostRepository;
import com.andersonbatista.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("02/03/2021"), "Partiu Viagem", "Vou viajar para São Paulo!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("03/03/2021"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa Viagem!", sdf.parse("04/03/2021"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("05/03/2021"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um bom proveito da viagem.", sdf.parse("06/03/2021"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}	
}




