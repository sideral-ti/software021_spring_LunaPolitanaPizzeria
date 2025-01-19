package com.sideralti.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;
    private String direccion;
    private boolean activo = true;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos = new HashSet<>();
}