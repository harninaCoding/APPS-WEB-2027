package com.adorno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Persona;
import com.adorno.repository.PersonaRepository;

@SpringBootTest
class GlobalTest {

	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	void test() {
		System.out.println("persona solo con anotacion Entity");
		personaRepository.save(new Persona("Arturo", "Somonte"));
	}

}
