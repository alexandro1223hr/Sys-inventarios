package com.inventario.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class RegistroIndiceId implements Serializable {

    @Column(name = "idRegistro")
    private Integer idRegistro;

    @Column(name = "idCampo")
    private Integer idCampo;
}
