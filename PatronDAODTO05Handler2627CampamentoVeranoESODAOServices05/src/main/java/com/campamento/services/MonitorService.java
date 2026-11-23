package com.campamento.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campamento.modelo.AbstractDAO.DaoFactory;
import com.campamento.modelo.AbstractDAO.MonitorDAO;
import com.campamento.modelo.Entity.Monitor;

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
