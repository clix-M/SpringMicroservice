package com.microservice.colegio.ctroller;



import com.microservice.colegio.models.Asignatura;
import com.microservice.colegio.persistence.AsignaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")

public class AsignaturaCtr {
    @Autowired
    private AsignaturaRepo asignaturaRepo;

    @GetMapping("/getasignaturas")
    public List<Asignatura> getAll() {
        return asignaturaRepo.findAll();
    }

    @GetMapping("/asignatura/{id}")
    public Asignatura getById(@PathVariable Long id) {
        return asignaturaRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/asignatura/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        asignaturaRepo.deleteById(id);
    }

    @PostMapping("/asignatura/save")
    public Asignatura save(@RequestBody Asignatura asignatura) {
        return asignaturaRepo.save(asignatura);
    }

    @PutMapping("/asignatura/update{id}")
    public Asignatura update(@RequestBody Asignatura asignatura, @PathVariable Long id) {
        Asignatura asignaturaUpdate = asignaturaRepo.findById(id).orElseThrow();
        asignaturaUpdate.setMateria(asignatura.getMateria());
        return asignaturaRepo.save(asignaturaUpdate);
    }

}
