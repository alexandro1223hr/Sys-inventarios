package com.inventario.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Personal")
@Getter @Setter @NoArgsConstructor
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonal")
    private Integer idPersonal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idSistema", nullable = false)
    private Sistema sistema;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    // 'supervisor' | 'vendedor'
    @Column(name = "rol", nullable = false, length = 25)
    private String rol;

    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String correo;

    // Nulo cuando inicia sesión con Google
    @Column(name = "contrasena", length = 255)
    private String contrasena;

    @Column(name = "eliminado", nullable = false)
    private Boolean eliminado = false;
}
