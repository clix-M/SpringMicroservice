package com.microservice.colegio.persistence;


import com.microservice.colegio.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepo extends JpaRepository<Asignatura, Long> {
}
