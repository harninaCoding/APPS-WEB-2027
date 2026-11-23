package com.campamento.modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import com.campamento.handler.CollectionHandler;
import com.campamento.handler.OptionalHandler;
import com.campamento.mapper.GrupoMapper;
import com.campamento.modelo.AbstractDAO.GrupoDAO;
import com.campamento.modelo.Entity.Grupo;
import com.campamento.modelo.acceso.AccessJdbc;

public class GrupoDAOJDBC implements GrupoDAO {
    private final AccessJdbc accessJdbc;
    private final GrupoMapper mapper = new GrupoMapper();

    public GrupoDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Grupo entidad) {
        String sql = "INSERT INTO grupo (numero_grupo, informaciones) VALUES (?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Grupo> findAll() {
        String sql = "SELECT numero_grupo, informaciones FROM grupo";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Grupo> findById(Integer id) {
        String sql = "SELECT numero_grupo, informaciones FROM grupo WHERE numero_grupo = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Grupo> deleteById(Integer id) {
        Optional<Grupo> grupo = findById(id);
        if (grupo.isPresent()) {
            String sql = "DELETE FROM grupo WHERE numero_grupo = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return grupo;
    }
}
