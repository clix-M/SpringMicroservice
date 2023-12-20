package com.microservice.colegio.persistence;

import com.microservice.colegio.models.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepo extends JpaRepository<Calificacion, Long> {
}
