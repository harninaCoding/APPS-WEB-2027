package com.campamento.services;

import java.util.Optional;

import com.campamento.modelo.Entity.NinoEso;

public interface CampamentoService {

	Optional<NinoEso> getNinoEsoById(int numeroNino);

	boolean create(NinoEso ninoEso);

	Optional<NinoEso> deleteNinoEsoById(int numeroNino);
}
