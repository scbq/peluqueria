package com.peluqueria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "peluqueras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Peluquera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "peluquera", cascade = CascadeType.ALL)
    private List<Cita> citas;
}
