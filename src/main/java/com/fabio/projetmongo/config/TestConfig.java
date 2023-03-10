package com.fabio.projetmongo.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fabio.projetmongo.models.entities.User;
import com.fabio.projetmongo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));		
	}

}
