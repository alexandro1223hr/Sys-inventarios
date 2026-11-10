package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Modulos")
@Getter @Setter @NoArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo")
    private Integer idModulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSistema", nullable = false)
    private Sistema sistema;

    @Column(name = "nombreModulo", nullable = false, length = 50)
    private String nombreModulo;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado = false;
}
