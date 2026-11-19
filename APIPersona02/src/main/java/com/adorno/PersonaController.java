package com.adorno;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
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
}
