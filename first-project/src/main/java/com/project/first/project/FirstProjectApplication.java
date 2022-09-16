package com.project.first.project;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.first.project.entities.User;
import com.project.first.project.repositories.UserRepository;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		User us = new User(null, "allan", "allan@gmail", " 11111");

		userRepository.saveAll(Arrays.asList(us));

	}

}
