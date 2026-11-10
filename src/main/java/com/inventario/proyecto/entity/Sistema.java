package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sistemas")
@Getter @Setter @NoArgsConstructor
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSistema")
    private Integer idSistema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nombreNegocio", nullable = false, length = 255)
    private String nombreNegocio;

    @Column(name = "colorPrincipal", nullable = false, length = 50)
    private String colorPrincipal;

    @Column(name = "colorSecundario", nullable = false, length = 50)
    private String colorSecundario;

    @Column(name = "logoUrl", length = 255)
    private String logoUrl;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado = false;
}
