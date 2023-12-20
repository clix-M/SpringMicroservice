package com.microservice.colegio.ctroller;


import com.microservice.colegio.models.Tutor;
import com.microservice.colegio.persistence.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class TutorCtr {
    @Autowired
    private TutorRepo tutorRepo;

    @GetMapping("/gettutores")
    private List<Tutor> getAll(){
        return tutorRepo.findAll();
    }

    @GetMapping("/tutor/{id}")
    private Tutor getById(@PathVariable Long id){
        return tutorRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/tutor/delete/{id}")
    private void deleteById(@PathVariable Long id){
        tutorRepo.deleteById(id);
    }

    @PostMapping("/tutor/save")
    private Tutor save(@RequestBody Tutor tutor){
        tutorRepo.save(tutor);
        return tutor;
    }

    @PutMapping("/tutor/update/{id}")
    private void update(@PathVariable Long id, @RequestBody Tutor tutor){
        Tutor tutorUpdate = tutorRepo.findById(id).orElseThrow();
        tutorUpdate.setNombre(tutor.getNombre());
        tutorUpdate.setApellidoPaterno(tutor.getApellidoPaterno());
        tutorUpdate.setApellidoMaterno(tutor.getApellidoMaterno());
        tutorUpdate.setTelefono(tutor.getTelefono());
        tutorRepo.save(tutorUpdate);
    }



}
