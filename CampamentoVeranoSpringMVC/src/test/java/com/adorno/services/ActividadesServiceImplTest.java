package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.DTO.ActividadesMonitorDTO;

@SpringBootTest
class ActividadesServiceImplTest {

	@Autowired
	ActividadesService actividadesService;
	
	@Test
	void testGetActividadesByMonitor() {
		ActividadesMonitorDTO actividadesByMonitor = actividadesService.getActividadesByMonitor("11111111A");
		System.out.println(actividadesByMonitor.toString());
		assertNotNull(actividadesByMonitor);
	}

}
