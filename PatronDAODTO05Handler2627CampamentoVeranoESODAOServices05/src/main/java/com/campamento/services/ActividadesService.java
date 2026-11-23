package com.campamento.services;

import com.campamento.modelo.DTO.ActividadesMonitorDTO;

public interface ActividadesService {
	public ActividadesMonitorDTO getActividadesByMonitor(String dni);
}
