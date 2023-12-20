package com.microservice.colegio.persistence;

import com.microservice.colegio.models.Maestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaestroRepo extends JpaRepository<Maestro, Long> {
}
