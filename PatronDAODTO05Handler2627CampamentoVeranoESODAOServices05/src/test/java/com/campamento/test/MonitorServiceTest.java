package com.campamento.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.campamento.modelo.Entity.Monitor;
import com.campamento.services.MonitorService;

class MonitorServiceTest {

	@Test
	void testGetMonitorById() {
		MonitorService monitorService = new MonitorService();
		Optional<Monitor> monitorById = monitorService.getMonitorById("22222222B");
		assertTrue(monitorById.isPresent());
		String name = "Laura";
		assertEquals(monitorById.get().getNombre(), name);
	}

}
