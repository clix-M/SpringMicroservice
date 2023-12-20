package com.mocroservice.course.mocroservicecourse.persistence;

import com.mocroservice.course.mocroservicecourse.entities.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepo extends JpaRepository<Asignatura, Long> {
}
