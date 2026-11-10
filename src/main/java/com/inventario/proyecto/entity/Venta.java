package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Ventas")
@Getter @Setter @NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSistema", nullable = false)
    private Sistema sistema;

    // Nulo cuando vende el usuario administrador
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersonal")
    private Personal personal;

    // Opcional
    @Column(name = "cliente", length = 100)
    private String cliente;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @PrePersist
    void prePersist() {
        if (fecha == null) fecha = LocalDate.now();
        if (hora == null) hora = LocalTime.now();
    }
}
