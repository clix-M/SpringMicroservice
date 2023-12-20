package com.microservice.colegio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Maestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaestro;

    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correo;
    private String CURP;
    private int RFC;


    @OneToOne
    @JoinColumn(name = "fk_Asignatura")
    private Asignatura asignatura;

    // @ManyToMany de Maestro con Grupo normalizar con tabla intermedia
    @ManyToMany
    @JoinTable(
            name = "Maestro_has_Grupo",
            joinColumns = @JoinColumn(name = "Maestro_idMaestro"),
            inverseJoinColumns = @JoinColumn(name = "Grupo_idGrupo")
    )
    private Set<Grupo> grupos = new HashSet<>();
}
