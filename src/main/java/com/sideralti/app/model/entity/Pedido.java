package com.sideralti.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
public class Pedido extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private Set<DetallePedido> detalles = new HashSet<>();
}