package com.adorno.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 12)
	private String nombre;
	@Column(name="nombreB")
	private String apodo;
	@Column(precision = 1)
	private float flotante;
	
	public Socio(String nombre, String apodo, float flotante) {
		super();
		this.nombre = nombre;
		this.apodo = apodo;
		this.flotante = flotante;
	}
	
}
