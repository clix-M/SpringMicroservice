package com.mocroservice.course.mocroservicecourse.controller;


import com.mocroservice.course.mocroservicecourse.client.AlumnoClient;
import com.mocroservice.course.mocroservicecourse.dto.AlumnoDTO;
import com.mocroservice.course.mocroservicecourse.dto.Calificacion;
import com.mocroservice.course.mocroservicecourse.entities.Asignatura;
import com.mocroservice.course.mocroservicecourse.http.AlumnogetById;
import com.mocroservice.course.mocroservicecourse.persistence.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/curso")

public class AsignaturaCtr {
    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @Autowired
    AlumnoClient alumnoClient;

    @GetMapping("/all")
    public List<Asignatura> getAll() {
        return asignaturaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Asignatura getById(@PathVariable Long id) {
        return asignaturaRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        asignaturaRepo.deleteById(id);
    }

    @PostMapping("/save")
    public Asignatura save(@RequestBody Asignatura asignatura) {
        return asignaturaRepo.save(asignatura);
    }

    @PutMapping("/update/{id}")
    public Asignatura update(@RequestBody Asignatura asignatura, @PathVariable Long id) {
        Asignatura asignaturaUpdate = asignaturaRepo.findById(id).orElseThrow();
        asignaturaUpdate.setMateria(asignatura.getMateria());
        return asignaturaRepo.save(asignaturaUpdate);
    }

    @GetMapping("/alumno/{id}")
    public AlumnogetById getAsignaturasByAlumnoId(@PathVariable Long id) {
        Asignatura asignatura = asignaturaRepo.findById(id).orElseThrow();
        AlumnoDTO alumnoDTO = alumnoClient.getById(id);

        // Obtener la calificación de la asignatura para el alumno
        String calificacion = alumnoDTO.getCalificaciones().stream()
                .filter(c -> c.asignatura().getIdAsignatura() == asignatura.getIdAsignatura())
                .findFirst()
                .map(Calificacion::calificacion)
                .orElse(null);

        // Crear una nueva lista de AlumnoDTO que solo contenga la información del alumno
        AlumnoDTO alumnoInfo = new AlumnoDTO();
        alumnoInfo.setIdAlumno(alumnoDTO.getIdAlumno());
        alumnoInfo.setNombreCompleto(alumnoDTO.getNombreCompleto());
        alumnoInfo.setGenero(alumnoDTO.getGenero());
        alumnoInfo.setCurp(alumnoDTO.getCurp());
        alumnoInfo.setFechaNac(alumnoDTO.getFechaNac());
        alumnoInfo.setDireccion(alumnoDTO.getDireccion());
        alumnoInfo.setTelefono(alumnoDTO.getTelefono());

        return AlumnogetById.builder()
                .asignatura(asignatura.getMateria())
                .calificacion(calificacion)
                .alumnoDTOList(List.of(alumnoInfo))
                .build();
    }

}
