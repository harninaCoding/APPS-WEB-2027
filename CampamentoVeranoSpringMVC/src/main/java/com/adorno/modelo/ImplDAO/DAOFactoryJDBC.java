package com.adorno.modelo.ImplDAO;

import java.sql.SQLException;

import com.adorno.modelo.AbstractDAO.ActividadDAO;
import com.adorno.modelo.AbstractDAO.DaoFactory;
import com.adorno.modelo.AbstractDAO.GrupoActividadMonitorDAO;
import com.adorno.modelo.AbstractDAO.GrupoDAO;
import com.adorno.modelo.AbstractDAO.MonitorDAO;
import com.adorno.modelo.AbstractDAO.NinoDAO;
import com.adorno.modelo.AbstractDAO.NinoEsoDAO;
import com.adorno.modelo.AbstractDAO.TiendaDAO;
import com.adorno.modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	private AccessJdbc accessJdbc;
	private final MonitorDAO monitorDAO;
	private final GrupoDAO grupoDAO;
	private final ActividadDAO actividadDAO;
	private final GrupoActividadMonitorDAO grupoActividadMonitorDAO;
	private final NinoEsoDAO ninoEsoDAO;
	private final NinoDAO ninoDAO;
	private final TiendaDAO tiendaDAO;

	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		// EStos parametros pueden ser pasado por parametros o configurados en otro
		// sitio
		accessJdbc = new AccessJdbc("campamento_verano_27", "harnina", "zzzz");
		this.monitorDAO = new MonitorDAOJDBC(accessJdbc);
		this.grupoDAO = new GrupoDAOJDBC(accessJdbc);
		this.actividadDAO = new ActividadDAOJDBC(accessJdbc);
		this.grupoActividadMonitorDAO = new GrupoActividadMonitorDAOJDBC(accessJdbc);
		this.ninoEsoDAO = new NinoEsoDAOJDBC(accessJdbc);
		this.ninoDAO = new NinoDAOJDBC(accessJdbc);
		this.tiendaDAO = new TiendaDAOJDBC(accessJdbc);
	}

	// Los singleton son los daos
	@Override
	public MonitorDAO getMonitorDAO() {
		return this.monitorDAO;
	}

	@Override
	public GrupoDAO getGrupoDAO() {
		return this.grupoDAO;
	}

	@Override
	public ActividadDAO getActividadDAO() {
		return this.actividadDAO;
	}

	@Override
	public GrupoActividadMonitorDAO getGrupoActividadMonitorDAO() {
		return this.grupoActividadMonitorDAO;
	}

	@Override
	public NinoEsoDAO getNinoEsoDAO() {
		return ninoEsoDAO;
	}

	public NinoDAO getNinoDAO() {
		return ninoDAO;
	}

	public TiendaDAO getTiendaDAO() {
		return tiendaDAO;
	}

}
