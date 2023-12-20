package com.microservice.colegio.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAsignatura;

    @Column(name = "Nombre_Materia")
    private String materia;

}
