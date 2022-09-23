package com.project.first.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.first.project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	/* UM OBJETO ESPECIFICO PARA ACESSAR OS DADOS DA ENTIDADE */
	
	/* Repositoris Spring JPA -- VOCÊ ACRESCENTA O 
	   "spring-boot-starter-data-jpa"  NO POM.XML  */       
	
	/* Repositoris Spring JPA -- SERVE PARA FAZER CONSULTAS NO BANCO DE DADOS */
}
