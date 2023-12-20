package com.microservice.colegio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_idAlumno")
    private int idAlumno;

    @Column(name = "Nombre_Completo")
    private String nombreCompleto;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "CURP")
    private String curp;

    @Column(name = "Fecha_nac")
    private String fechaNac;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "fk_Grupo")
    private Grupo grupo;


    // @ManyToMany de Alumno con Colegiatura normalizar con tabla intermedia
    @ManyToMany
    @JoinTable(
            name = "Alumno_has_Colegiatura",
            joinColumns = @JoinColumn(name = "Alumno_idAlumno"),
            inverseJoinColumns = @JoinColumn(name = "Colegiatura_idColegiatura")
    )
    private Set<Colegiatura> colegiaturas = new HashSet<>();

    // @ManyToMany de Alumno con Tutor normalizar con tabla intermedia
    @ManyToMany
    @JoinTable(
            name = "Alumno_has_Tutor",
            joinColumns = @JoinColumn(name = "Alumno_idAlumno"),
            inverseJoinColumns = @JoinColumn(name = "Tutor_idTutor")
    )
    private Set<Tutor> tutores = new HashSet<>();

    // @ManyToMany de Alumno con calificacion normalizar con tabla intermedia
    @ManyToMany
    @JoinTable(
            name = "Alumno_has_Calificacion",
            joinColumns = @JoinColumn(name = "Alumno_idAlumno"),
            inverseJoinColumns = @JoinColumn(name = "Calificacion_idCalificacion")
    )
    private Set<Calificacion> calificaciones = new HashSet<>();


}