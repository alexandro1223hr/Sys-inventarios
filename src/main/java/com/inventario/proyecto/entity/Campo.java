package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Campos")
@Getter
@Setter
@NoArgsConstructor
public class Campo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCampo")
    private Integer idCampo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idModulo", nullable = false)
    private Modulo modulo;

    @Column(name = "nombreCampo", nullable = false, length = 50)
    private String nombreCampo;

    // 'texto' | 'numero' | 'precio decimal' | 'fecha' | 'imagen'
    @Column(name = "tipoCampo", nullable = false, length = 20)
    private String tipoCampo;

    @Column(name = "filtrable", nullable = false)
    private Boolean filtrable = false;

    @Column(name = "orden", nullable = false)
    private Integer orden = 0;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado = false;
}
