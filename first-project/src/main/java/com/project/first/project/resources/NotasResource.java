package com.project.first.project.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.first.project.dto.NotasDTO;
import com.project.first.project.entities.Notas;
import com.project.first.project.services.NotasServices;

@RestController
@RequestMapping(value = "/notas")
public class NotasResource {
	
	@Autowired
	private NotasServices service;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Notas> find(@PathVariable Integer id) {
		Notas obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert( @RequestBody NotasDTO objDto){
		Notas obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //pega o id do objeto e passa pra url
		return ResponseEntity.created(uri).build();
		/* cria um novo usuario no banco de dados */
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update( @RequestBody NotasDTO objDto, @PathVariable Integer id){
		Notas obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<NotasDTO>> findAll() {	
		List<Notas> list = service.findAll();
		List<NotasDTO> listDto = list.stream().map(obj -> new NotasDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);		
		//reporta todas as categorias
	}
}
