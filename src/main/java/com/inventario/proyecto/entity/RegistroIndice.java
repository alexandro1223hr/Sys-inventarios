package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "RegistrosIndice")
@Getter @Setter @NoArgsConstructor
public class RegistroIndice {

    @EmbeddedId
    private RegistroIndiceId id = new RegistroIndiceId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idRegistro")
    @JoinColumn(name = "idRegistro", nullable = false)
    private Registro registro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("idCampo")
    @JoinColumn(name = "idCampo", nullable = false)
    private Campo campo;

    @Column(name = "idModulo", nullable = false)
    private Integer idModulo;

    @Column(name = "valorTexto", length = 255)
    private String valorTexto;

    @Column(name = "valorNumero", precision = 18, scale = 4)
    private BigDecimal valorNumero;

    @Column(name = "valorFecha")
    private LocalDateTime valorFecha;
}
