package com.microservice.colegio.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
public class Colegiatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_idColegiatura")
    private int idColegiatura;

    @Column(name = "Monto")
    private String monto;

    @Column(name = "Mes")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date mes;

    @Enumerated(EnumType.STRING)
    @Column(name = "Pagada")
    private Pagada pagada;





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Colegiatura that)) return false;
        return idColegiatura == that.idColegiatura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idColegiatura);
    }
}