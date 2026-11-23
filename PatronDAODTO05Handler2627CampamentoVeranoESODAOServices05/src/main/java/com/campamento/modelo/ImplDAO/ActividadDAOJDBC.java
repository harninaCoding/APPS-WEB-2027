package com.campamento.modelo.ImplDAO;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.campamento.handler.CollectionHandler;
import com.campamento.handler.OptionalHandler;
import com.campamento.mapper.ActividadMapper;
import com.campamento.modelo.AbstractDAO.ActividadDAO;
import com.campamento.modelo.Entity.Actividad;
import com.campamento.modelo.acceso.AccessJdbc;

public class ActividadDAOJDBC implements ActividadDAO {
    private final AccessJdbc accessJdbc;
    private final ActividadMapper mapper = new ActividadMapper();

    public ActividadDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Actividad entidad) {
        String sql = "INSERT INTO actividad (codigo_actividad, nombre_actividad, descripcion) VALUES (?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Actividad> findAll() {
        String sql = "SELECT codigo_actividad, nombre_actividad, descripcion FROM actividad";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Actividad> findById(String id) {
        String sql = "SELECT codigo_actividad, nombre_actividad, descripcion FROM actividad WHERE codigo_actividad = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Actividad> deleteById(String id) {
        Optional<Actividad> actividad = findById(id);
        if (actividad.isPresent()) {
            String sql = "DELETE FROM actividad WHERE codigo_actividad = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return actividad;
    }

    @Override
    public Collection<Actividad> findAllById(List<String> codigosActividades) {
        String parametros = String.join(",", Collections.nCopies(codigosActividades.size(), "?"));
        String sql = "SELECT codigo_actividad, nombre_actividad, descripcion FROM actividad WHERE codigo_actividad IN ("
                + parametros + ")";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper), codigosActividades.toArray());
    }
}
