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

import com.project.first.project.entities.Notas;
import com.project.first.project.repositories.NotasRepository;

@RestController /* DECLARA QUE VAI SER UM CONTROLADOR (VAI FAZER REQUISIÇÕES CRUD) */
@RequestMapping(value = "/notas") /* CAMINHO QUE VAI RESPONDER */
public class NotasServices {
	
	@Autowired
	private NotasRepository repository;
	
	@GetMapping(value = "/{id}")
	public Notas find(@PathVariable Integer id) {		
		return repository.findById(id).get();
	}

	@GetMapping
	public List<Notas> findAll() {
		return repository.findAll();
	}
	
	
	@PostMapping //"INSERT" Salva um novo usuário
	public Notas insert(@RequestBody Notas notas){
		Notas result = repository.save(notas); //Salva um novo usuário no banco
		return result;
	
}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
	@PutMapping
	public Notas update(@RequestBody Notas notas) {
		Notas obj = find(notas.getId());
		updateData(obj, notas);
		return repository.save(obj);
	}
	
	private void updateData(Notas obj, Notas user) {		
		obj.setDate(user.getDate()); //o newObj que a gente procurou no banco ele foi atualizado com os novos dados obj
		obj.setPreco(user.getPreco());
		
	}

}
