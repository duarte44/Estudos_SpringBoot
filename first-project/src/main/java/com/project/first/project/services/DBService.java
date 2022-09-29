package com.project.first.project.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.first.project.entities.Notas;
import com.project.first.project.entities.User;
import com.project.first.project.repositories.NotasRepository;
import com.project.first.project.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NotasRepository notasRepository;
	
	public void instantiateTestDatabase() throws ParseException {	
		
		
			User us = new User(null, "allan", "allan@gmail", " 11111");
			User us2 = new User(null, "ovidio", "ovidio@gmail", " 22222");		
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			Notas n1 = new Notas(null, 2000.00, sdf.parse("30/09/2017 10:32"));
			Notas n2 = new Notas(null, 3000.00, sdf.parse("31/09/2017 10:32"));
			Notas n3 = new Notas(null, 4000.00, sdf.parse("10/10/2017 10:32"));

			n1.getUser().addAll(Arrays.asList(us));
			n2.getUser().addAll(Arrays.asList(us));
			n3.getUser().addAll(Arrays.asList(us2));		

			us.getNotas().addAll(Arrays.asList(n1,n2));
			us2.getNotas().addAll(Arrays.asList(n3));
							
			notasRepository.saveAll(Arrays.asList(n1, n2, n3));	
			userRepository.saveAll(Arrays.asList(us, us2));	
	
	
	}
}
