package com.microservice.colegio.ctroller;



import com.microservice.colegio.models.Grado;
import com.microservice.colegio.persistence.GradoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class GradoCtr {
    @Autowired
    private GradoRepo gradoRepo;

    @GetMapping("/getgrados")
    public List<Grado> getAll() {
        return gradoRepo.findAll();
    }

    @GetMapping("/grado/{id}")
    public Grado getById(@PathVariable Long id) {
        return gradoRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/grado/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        gradoRepo.deleteById(id);
    }

    @PostMapping("/grado/save")
    public Grado save(@RequestBody Grado grado) {
        return gradoRepo.save(grado);
    }

    @PutMapping("/grado/update{id}")
    public Grado update(@RequestBody Grado grado, @PathVariable Long id) {
        Grado gradoUpdate = gradoRepo.findById(id).orElseThrow();
        gradoUpdate.setGrado(grado.getGrado());
        return gradoRepo.save(gradoUpdate);
    }

}
