package com.adorno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.entities.Persona;
import com.adorno.services.PersonaService;

@RestController
public class PersonaController {
	
	//Spring es el encargado de crear e inyectar el componente, en este caso un service
	private final PersonaService personaService;
	
	//Este es el mecanismo para inyectar un servicio en el controller
	//aunque hay 1000 controllers que inyecten este servicio, los mil reciben el mismo objeto
	public PersonaController(PersonaService personaService) {
		this.personaService=personaService;
	}

	@GetMapping("/persona")
	public Optional<Persona> getPersonaById(@RequestParam int id){
		return personaService.findByID(id);
	}
	@DeleteMapping("/persona")
	public Optional<Persona> deletePersonaById(@RequestParam int id){
		return personaService.borrar(id);
	}
	
	@GetMapping("/persona/all")
	public List<Persona> getAll(){
		return personaService.findAll();
	}
	@PostMapping("/persona")
	public boolean createPersona(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}
	// Necesitamos lalista de las personas con mas de 20 annos
	@GetMapping("/persona/edad")
	public List<Persona> findPersonasByEdad20(){
		return personaService.getByEdad(20);
	}
	
	//Necesitamos la cantidad de personas entre dos edades dadas
}
