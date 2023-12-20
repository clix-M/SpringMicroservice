package com.microservice.colegio.persistence;

import com.microservice.colegio.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepo extends JpaRepository<Tutor, Long> {
}
