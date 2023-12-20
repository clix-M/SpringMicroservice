package com.microservice.colegio.persistence;


import com.microservice.colegio.models.Colegiatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColegiaturaRepo extends JpaRepository<Colegiatura,Long> {
}
