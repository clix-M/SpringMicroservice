package com.microservice.colegio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCalificacion;

    @Enumerated(EnumType.STRING)
    private Bimestre bimestre;

    @Column(name = "Calificacion")
    private String calificacion;



    @ManyToOne
    @JoinColumn(name = "Asignatura_idAsignatura")
    private Asignatura asignatura;





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calificacion that)) return false;
        return idCalificacion == that.idCalificacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCalificacion);
    }
}
