package com.microservice.colegio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTutor;
    private String nombre;
    @Column(name = "Apellido_Paterno")
    private String apellidoPaterno;
    @Column(name = "Apellido_Materno")
    private String apellidoMaterno;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "TipoParentesco_idTipoParentesco")
    private TipoParentesco tipoParentesco;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor tutor)) return false;
        return idTutor == tutor.idTutor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTutor);
    }
}
