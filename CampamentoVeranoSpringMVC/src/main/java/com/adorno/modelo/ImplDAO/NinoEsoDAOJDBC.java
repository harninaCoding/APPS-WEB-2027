package com.adorno.modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import com.adorno.handler.CollectionHandler;
import com.adorno.handler.OptionalHandler;
import com.adorno.mapper.NinoEsoMapper;
import com.adorno.modelo.AbstractDAO.NinoEsoDAO;
import com.adorno.modelo.Entity.NinoEso;
import com.adorno.modelo.acceso.AccessJdbc;

public class NinoEsoDAOJDBC implements NinoEsoDAO {
    private final AccessJdbc accessJdbc;
    private final NinoEsoMapper mapper = new NinoEsoMapper();

    public NinoEsoDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(NinoEso entidad) {
        String sqlNinoEso = "INSERT INTO nino_eso (numero_nino, numero_tienda) VALUES (?, ?)";
        int filas = accessJdbc.executeUpdate(sqlNinoEso, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<NinoEso> findAll() {
        String sql = "SELECT numero_nino, numero_tienda FROM nino_eso";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<NinoEso> findById(Integer id) {
        String sql = "SELECT numero_nino, numero_tienda FROM nino_eso WHERE numero_nino = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<NinoEso> deleteById(Integer id) {
        Optional<NinoEso> nino = findById(id);
        if (nino.isPresent()) {
            String sql = "DELETE FROM nino_eso WHERE numero_nino = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return nino;
    }
}