package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "MovimientosInventario")
@Getter @Setter @NoArgsConstructor
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimiento")
    private Integer idMovimiento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSistema", nullable = false)
    private Sistema sistema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    // 'Entrada' | 'Salida' | 'Ajuste'
    @Column(name = "tipo", nullable = false, length = 10)
    private String tipo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;

    @PrePersist
    void prePersist() {
        if (fecha == null) fecha = LocalDate.now();
        if (hora == null) hora = LocalTime.now();
    }
}
