package com.campamento.modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import com.campamento.handler.CollectionHandler;
import com.campamento.handler.OptionalHandler;
import com.campamento.mapper.MonitorMapper;
import com.campamento.modelo.AbstractDAO.MonitorDAO;
import com.campamento.modelo.Entity.Monitor;
import com.campamento.modelo.acceso.AccessJdbc;

public class MonitorDAOJDBC implements MonitorDAO {
    private final AccessJdbc accessJdbc;
    private final MonitorMapper mapper = new MonitorMapper();

    public MonitorDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Monitor entidad) {
        String sql = "INSERT INTO monitor (dni, nombre, apellidos, telefono) VALUES (?, ?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Monitor> findAll() {
        String sql = "SELECT dni, nombre, apellidos, telefono FROM monitor";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Monitor> findById(String id) {
        String sql = "SELECT dni, nombre, apellidos, telefono FROM monitor WHERE dni = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Monitor> deleteById(String id) {
        Optional<Monitor> monitor = findById(id);
        if (monitor.isPresent()) {
            String sql = "DELETE FROM monitor WHERE dni = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return monitor;
    }
}
