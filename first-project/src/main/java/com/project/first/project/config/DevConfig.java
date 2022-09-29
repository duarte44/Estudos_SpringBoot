package com.project.first.project.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.first.project.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy; 
	// pega o valor da variavel spring.jpa.hibernate.ddl-auto e testa para ver se vai instanciar o banco
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false; // se o valor for diferente de "create" ele n instancia o banco
			
		}
		
		
		
		dbService.instantiateTestDatabase();
			
		return true;
	}
}
