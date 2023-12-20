package com.microservice.colegio.persistence;

import com.microservice.colegio.models.TipoParentesco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoParentescoRepo extends JpaRepository<TipoParentesco, Long> {
}
