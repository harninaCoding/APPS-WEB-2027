package com.adorno.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.AbstractDAO.DaoFactory;
import com.adorno.modelo.AbstractDAO.MonitorDAO;
import com.adorno.modelo.Entity.Monitor;

@Service
public class MonitorService {
	private final MonitorDAO monitorDAO;

	public MonitorService() {
		super();
		this.monitorDAO = DaoFactory.getFactory().getMonitorDAO();

	}

	public MonitorDAO getMonitorDAO() {
		return monitorDAO;
	}

	public Optional<Monitor> getMonitorById(String dni) {
		return this.monitorDAO.findById(dni);
	}
}
