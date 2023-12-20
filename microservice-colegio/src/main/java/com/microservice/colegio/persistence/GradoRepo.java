package com.microservice.colegio.persistence;


import com.microservice.colegio.models.Grado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GradoRepo extends JpaRepository<Grado, Long> {
}
