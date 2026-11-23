package com.adorno.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.adorno.modelo.AbstractDAO.ActividadDAO;
import com.adorno.modelo.AbstractDAO.DaoFactory;
import com.adorno.modelo.AbstractDAO.GrupoActividadMonitorDAO;
import com.adorno.modelo.AbstractDAO.MonitorDAO;
import com.adorno.modelo.DTO.ActividadesMonitorDTO;
import com.adorno.modelo.Entity.Actividad;
import com.adorno.modelo.Entity.GrupoActividadMonitor;
import com.adorno.modelo.Entity.Monitor;

@Service
public class ActividadesServiceImpl implements ActividadesService {
	private final GrupoActividadMonitorDAO grupoActividadMonitorDAO;
	private final ActividadDAO actividadDAO;
	private final MonitorDAO monitorDAO;

	public ActividadesServiceImpl() {
		super();
		grupoActividadMonitorDAO = DaoFactory.getFactory().getGrupoActividadMonitorDAO();
		this.actividadDAO = DaoFactory.getFactory().getActividadDAO();
		this.monitorDAO = DaoFactory.getFactory().getMonitorDAO();
	}

	// step 1 en clase
	// @Override
	// public ActividadesMonitorDTO getActividadesByMonitor(String dni) {
	// Collection<GrupoActividadMonitor>
	// actividades=grupoActividadMonitorDAO.findByMonitor(dni);
	// GrupoActividadMonitor grupoActividadMonitor =
	// actividades.stream().collect(Collectors.toList()).get(0);
	// Actividad actividad =
	// actividadDAO.findById(grupoActividadMonitor.getActividad().getCodigoActividad()).get();
	// String descripcion = actividad.getDescripcion();
	// //Pero es lazy
	// return null;
	// }
	// step 2 profesor liandola parda
	@Override
	public ActividadesMonitorDTO getActividadesByMonitor(String dni) {
		Collection<GrupoActividadMonitor> actividades = grupoActividadMonitorDAO.findByMonitor(dni);
		List<String> collect = actividades.stream()
				.map(GrupoActividadMonitor::getActividad)
				.map(Actividad::getCodigoActividad)
				.collect(Collectors.toList());
		Collection<Actividad> all = actividadDAO.findAll();
		// abajo se hace creando otra consulta en el dao de actividades
		Collection<String> collect2 = all.stream()
				.filter(act -> collect.contains(act.getCodigoActividad()))
				.map(Actividad::getDescripcion)
				.collect(Collectors.toCollection(ArrayList::new));
		return new ActividadesMonitorDTO(monitorDAO.findById(dni).get().getNombre(), collect2);
	}

	public ActividadesMonitorDTO getActividadesByMonitorCollapse(String dni) throws EntityNotFoundException {
		Monitor monitor = monitorDAO.findById(dni)
				.orElseThrow(() -> new EntityNotFoundException());

		// 1. Obtener la lista de IDs de las actividades
		List<String> codigosActividades = grupoActividadMonitorDAO.findByMonitor(dni).stream()
				.map(GrupoActividadMonitor::getActividad)
				.map(Actividad::getCodigoActividad)
				.collect(Collectors.toList());

		if (codigosActividades.isEmpty()) {
			return new ActividadesMonitorDTO(monitor.getNombre(), Collections.emptyList());
		}

		// 2. Traer de BD ÚNICAMENTE las actividades necesarias y extraer sus
		// descripciones
		List<String> descripciones = actividadDAO.findAllById(codigosActividades).stream()
				.map(Actividad::getDescripcion)
				.collect(Collectors.toList());

		return new ActividadesMonitorDTO(monitor.getNombre(), descripciones);
	}

}
