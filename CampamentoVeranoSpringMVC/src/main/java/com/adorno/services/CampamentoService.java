package com.adorno.services;

import java.util.Optional;

import com.adorno.modelo.Entity.NinoEso;

public interface CampamentoService {

	Optional<NinoEso> getNinoEsoById(int numeroNino);

	boolean create(NinoEso ninoEso);

	Optional<NinoEso> deleteNinoEsoById(int numeroNino);
}
