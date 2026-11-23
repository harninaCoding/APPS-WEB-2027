package com.adorno.services;

import com.adorno.modelo.DTO.ActividadesMonitorDTO;

public interface ActividadesService {
	public ActividadesMonitorDTO getActividadesByMonitor(String dni);
}
