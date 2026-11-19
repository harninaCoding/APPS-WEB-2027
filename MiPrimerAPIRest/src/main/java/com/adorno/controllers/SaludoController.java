package com.adorno.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
//VAMOS A definir los endpoints
	//un endopint es un acceso controlado a un recurso del servidor
	@GetMapping("/saludo")
	public String saludar() {
		String string = "Hola Mundo";
		return string;
	}
}
