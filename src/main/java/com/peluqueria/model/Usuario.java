package com.peluqueria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String unidad;

    @Column(nullable = false)
    private String anexo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // ADMIN o USER

    public enum Role {
        ADMIN, USER
    }
}
