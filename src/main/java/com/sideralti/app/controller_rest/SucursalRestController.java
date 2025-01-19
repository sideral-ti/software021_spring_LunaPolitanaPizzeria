package com.sideralti.app.controller_rest;

import com.sideralti.app.base.controller.BaseCrudController;
import com.sideralti.app.base.service.BaseCrudService;
import com.sideralti.app.model.entity.Sucursal;
import com.sideralti.app.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/sucursales")
public class SucursalRestController extends BaseCrudController<Sucursal, Long> {

    @Autowired
    private SucursalService sucursalService;

    public SucursalRestController(BaseCrudService<Sucursal, Long> service) {
        super(service);
    }

    @Override
    protected Long getEntityId(Sucursal entity) {
        return entity.getId();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Sucursal> findByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(sucursalService.findByNombre(nombre));
    }


}