package com.project.first.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.first.project.entities.User;
import com.project.first.project.repositories.UserRepository;

@RestController /* DECLARA QUE VAI SER UM CONTROLADOR (VAI FAZER REQUISIÇÕES CRUD) */
@RequestMapping(value = "/users") /* CAMINHO QUE VAI RESPONDER */
public class UsersServices {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(value = "/{id}")
	public User find(@PathVariable Long id) {		
		return repository.findById(id).get();
	}

	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}
	
	
	@PostMapping //"INSERT" Salva um novo usuário
	public User insert(@RequestBody User user){
		User result = repository.save(user); //Salva um novo usuário no banco
		return result;
	
}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		User obj = find(user.getId());
		updateData(obj, user);
		return repository.save(obj);
	}
	
	private void updateData(User obj, User user) {		
		obj.setName(user.getName()); //o newObj que a gente procurou no banco ele foi atualizado com os novos dados obj
		obj.setEmail(user.getEmail());
		obj.setSenha(user.getSenha());
	}

}
