package com.campamento.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ActividadesServiceImplTest {

	@Autowired
	ActividadesServiceImpl actividadesService;
	
	@Test
	void testGetActividadesByMonitor() {
		actividadesService.getActividadesByMonitor("11111111A");
	}

}
