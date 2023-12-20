package com.microservice.colegio.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGrupo;

    // ManyToOne de Grupo con Grado
    @ManyToOne
    @JoinColumn(name = "fk_Grado")
    private Grado grado;

}
