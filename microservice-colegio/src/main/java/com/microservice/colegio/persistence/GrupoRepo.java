package com.microservice.colegio.persistence;

import com.microservice.colegio.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepo extends JpaRepository<Grupo, Long> {
}
