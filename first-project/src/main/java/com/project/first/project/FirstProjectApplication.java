package com.project.first.project;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.first.project.entities.Notas;
import com.project.first.project.entities.User;
import com.project.first.project.repositories.NotasRepository;
import com.project.first.project.repositories.UserRepository;
import com.project.first.project.services.NotasServices;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub

				
	
	}

}
