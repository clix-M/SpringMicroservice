package com.microservice.colegio.persistence;

import com.microservice.colegio.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepo extends JpaRepository<Alumno,Long> {
}
