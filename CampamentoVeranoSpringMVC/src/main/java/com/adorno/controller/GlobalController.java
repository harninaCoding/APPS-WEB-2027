package com.adorno.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

	
	@GetMapping("prueba")
	public String funcionando() {
		return "por los pelillos";
	}
}
