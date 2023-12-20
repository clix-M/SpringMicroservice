package com.mocroservice.course.mocroservicecourse.client;

import com.mocroservice.course.mocroservicecourse.dto.AlumnoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-alumno", url = "localhost:8080/api/colegio")
public interface AlumnoClient {

    @GetMapping("/alumno/{id}")
    AlumnoDTO getById(@PathVariable Long id);
}
