package com.microservice.colegio.ctroller;


import com.microservice.colegio.models.Alumno;
import com.microservice.colegio.models.Calificacion;
import com.microservice.colegio.models.Colegiatura;
import com.microservice.colegio.models.Tutor;
import com.microservice.colegio.persistence.AlumnoRepo;
import com.microservice.colegio.persistence.CalificacionRepo;
import com.microservice.colegio.persistence.ColegiaturaRepo;
import com.microservice.colegio.persistence.TutorRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class AlumnoCtr {
    @Autowired
    private AlumnoRepo alumnoRepo;
    @Autowired
    private ColegiaturaRepo colegiaturaRepo;
    @Autowired
    private TutorRepo tutorRepo;
    @Autowired
    private CalificacionRepo calificacionRepo;


    @GetMapping("/getalumnos")
    private List<Alumno> getAll(){
        return alumnoRepo.findAll();
    }

    @GetMapping("/alumno/{id}")
    private Alumno getById(@PathVariable Long id){
        return alumnoRepo.findById(id).orElseThrow();
    }
   /* private Alumno getById(@PathVariable Long id){
        return alumnoRepo.findById(id).get();
    }*/

    @DeleteMapping("/alumno/delete/{id}")
    private void deleteById(@PathVariable Long id){
        alumnoRepo.deleteById(id);
    }

    @PostMapping("/alumno/save")
    private ResponseEntity<?>  save(@RequestBody Alumno alumno){
        for (Colegiatura colegiatura : alumno.getColegiaturas()) {
            if (!colegiaturaRepo.existsById((long) colegiatura.getIdColegiatura())) {
                return new ResponseEntity<>("Colegiatura with id " + colegiatura.getIdColegiatura() + " does not exist", HttpStatus.BAD_REQUEST);
            }
        }
        for (Tutor tutor : alumno.getTutores()) {
            if (!tutorRepo.existsById((long) tutor.getIdTutor())) {
                return new ResponseEntity<>("Tutor with id " + tutor.getIdTutor() + " does not exist", HttpStatus.BAD_REQUEST);
            }
        }

        for (Calificacion calificacion : alumno.getCalificaciones()) {
            if (!calificacionRepo.existsById((long) calificacion.getIdCalificacion())) {
                // create new calificacion
                calificacionRepo.save(calificacion);

            }
        }

        alumnoRepo.save(alumno);
        // retorna un mensaje de que se creo correctamente
        return new ResponseEntity<>("Alumno created successfully", HttpStatus.OK);

    }

    @PutMapping("/alumno/update/{id}")
    private void update(@PathVariable Long id, @RequestBody Alumno alumno){
        Alumno alumnoUpdate = alumnoRepo.findById(id).orElseThrow();
        alumnoUpdate.setNombreCompleto(alumno.getNombreCompleto());
        alumnoUpdate.setGenero(alumno.getGenero());
        alumnoUpdate.setCurp(alumno.getCurp());
        alumnoUpdate.setFechaNac(alumno.getFechaNac());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        alumnoUpdate.setTelefono(alumno.getTelefono());
    //    alumnoUpdate.setIdGrupo(alumno.getIdGrupo());
        alumnoRepo.save(alumnoUpdate);

    }
}
