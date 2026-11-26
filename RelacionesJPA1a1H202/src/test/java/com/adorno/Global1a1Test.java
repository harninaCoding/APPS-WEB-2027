package com.adorno;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Direccion;
import com.adorno.modelo.Persona;
import com.adorno.modelo.Poliza;
import com.adorno.repositories.DireccionRepository;
import com.adorno.repositories.PersonaRepository;

@SpringBootTest
class Global1a1Test {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DireccionRepository direccionRepository;
	@Test
	void test() {
		Poliza poliza=new Poliza(2l, LocalDate.now());
		Direccion mia=new Direccion("nueva", 23);
		direccionRepository.save(mia);
		Persona persona=new Persona("Luis", "Gomez", mia,poliza);
		personaRepository.save(persona);
	}

}
