package com.sideralti.app.service;

import com.sideralti.app.base.service.BaseCrudService;
import com.sideralti.app.model.entity.Sucursal;

public interface SucursalService extends BaseCrudService<Sucursal, Long> {

    Sucursal findByNombre(String nombre);




}
