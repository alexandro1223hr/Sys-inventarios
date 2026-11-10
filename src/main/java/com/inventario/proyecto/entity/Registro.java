package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "Registros")
@Getter @Setter @NoArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistro")
    private Integer idRegistro;

    // La BD valida que (idModulo, idSistema) sea un par válido con una FK compuesta
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSistema", nullable = false)
    private Sistema sistema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idModulo", nullable = false)
    private Modulo modulo;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "datos", nullable = false, columnDefinition = "jsonb")
    private Map<String, Object> datos;
}
