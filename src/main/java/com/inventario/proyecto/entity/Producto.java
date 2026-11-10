package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Productos")
@Getter @Setter @NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSistema", nullable = false)
    private Sistema sistema;

    @Column(name = "nombreProducto", nullable = false, length = 120)
    private String nombreProducto;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "stockMinimo", nullable = false)
    private Integer stockMinimo;

    @Column(name = "fechaVencimiento")
    private LocalDateTime fechaVencimiento;

    @Column(name = "lote", length = 120)
    private String lote;

    @Column(name = "imagenUrl", length = 255)
    private String imagenUrl;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado = false;
}
