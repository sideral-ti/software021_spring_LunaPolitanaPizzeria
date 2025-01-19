package com.sideralti.app.repository;

import com.sideralti.app.base.repository.BaseRepository;
import com.sideralti.app.model.entity.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SucursalRepository extends BaseRepository<Sucursal, Long> {
    boolean existsByNombre(String nombre);
    Optional<Sucursal> findByNombre(String nombre);
}