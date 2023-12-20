package com.microservice.colegio.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TipoParentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoParentesco;

    private String descripcion;

}
