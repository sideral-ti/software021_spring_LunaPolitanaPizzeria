package com.sideralti.app.service.impl;

import com.sideralti.app.base.repository.BaseRepository;
import com.sideralti.app.base.service.impl.BaseCrudServiceImpl;
import com.sideralti.app.exceptions.BusinessException;
import com.sideralti.app.exceptions.ResourceNotFoundException;
import com.sideralti.app.model.entity.Sucursal;
import com.sideralti.app.repository.SucursalRepository;
import com.sideralti.app.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SucursalServiceImpl extends BaseCrudServiceImpl<Sucursal, Long> implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalServiceImpl(BaseRepository<Sucursal, Long> repository) {
        super(repository);
    }

    @Override
    protected String getEntityName() {
        return "Sucursal";
    }

    @Override
    protected void validateBeforeSave(Sucursal sucursal) {
        if (sucursalRepository.existsByNombre(sucursal.getNombre())) {
            throw new BusinessException("Ya existe una sucursal con el nombre: " + sucursal.getNombre());
        }
    }

    @Override
    protected void validateBeforeUpdate(Long id, Sucursal sucursal) {
        Optional<Sucursal> existingSucursal = sucursalRepository.findByNombre(sucursal.getNombre());
        if (existingSucursal.isPresent() && !existingSucursal.get().getId().equals(id)) {
            throw new BusinessException("Ya existe una sucursal con el nombre: " + sucursal.getNombre());
        }
    }

    @Override
    protected void validateBeforeDelete(Long id) {
        // Implementar validaciones antes de eliminar
    }

    @Override
    public Sucursal findByNombre(String nombre) {
        return sucursalRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal", "nombre", nombre));
    }
}