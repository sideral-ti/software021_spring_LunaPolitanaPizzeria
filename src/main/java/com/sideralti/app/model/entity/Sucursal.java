package com.sideralti.app.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "sucursales")
//@AllArgsConstructor
//@NoArgsConstructor
public class Sucursal extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    private String telefono;
    private String email;
    private boolean activo = true;

    @Column(name = "fecha_apertura")
    private LocalDateTime fechaApertura;

//    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
//    private Set<Empleado> empleados = new HashSet<>();
//
//    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
//    private Set<Inventario> inventarios = new HashSet<>();

    @OneToMany(mappedBy = "sucursal")
    private Set<Pedido> pedidos = new HashSet<>();

    public Sucursal() {
    }

    public Sucursal(Long id, String nombre, String direccion, String telefono, String email, boolean activo, LocalDateTime fechaApertura, Set<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.activo = activo;
        this.fechaApertura = fechaApertura;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}