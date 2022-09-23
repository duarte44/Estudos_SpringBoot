package com.project.first.project.dto;

import java.io.Serializable;

import com.project.first.project.entities.User;


public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	//DTO DEFINE O QUE VAI SER VOLTADO
	
	private Integer id;
	
	private String nome;
	private String email;
	private String senha;

	
	public UserDTO() {
		
	}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();			
		this.nome = obj.getName();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
