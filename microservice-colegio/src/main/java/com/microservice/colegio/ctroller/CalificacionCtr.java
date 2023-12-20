package com.microservice.colegio.ctroller;


import com.microservice.colegio.models.Calificacion;
import com.microservice.colegio.persistence.CalificacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class CalificacionCtr {
    @Autowired
    private CalificacionRepo calificacionRepo;

    @GetMapping("/getcalificaciones")
    private List<Calificacion> getAll(){
        return calificacionRepo.findAll();
    }

    @GetMapping("/calificacion/{id}")
    private Calificacion getById(@PathVariable Long id){
        return calificacionRepo.findById(id).get();
    }

    @DeleteMapping("/calificacion/delete/{id}")
    private void deleteById(@PathVariable Long id){
        calificacionRepo.deleteById(id);
    }

    @PostMapping("/calificacion/save")
    private Calificacion save(@RequestBody Calificacion calificacion){
        return calificacionRepo.save(calificacion);
    }

    @PutMapping("/calificacion/update/{id}")
    private Calificacion update(@RequestBody Calificacion calificacion, @PathVariable Long id){
        Calificacion caliUpdate = calificacionRepo.findById(id).orElseThrow();
        caliUpdate.setBimestre(calificacion.getBimestre());
        caliUpdate.setCalificacion(calificacion.getCalificacion());
        return calificacionRepo.save(caliUpdate);

    }
}
