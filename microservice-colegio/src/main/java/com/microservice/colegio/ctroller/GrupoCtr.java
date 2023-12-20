package com.microservice.colegio.ctroller;

import com.microservice.colegio.models.Grupo;
import com.microservice.colegio.persistence.GrupoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class GrupoCtr {
    @Autowired
    private GrupoRepo grupoRepo;

    @GetMapping("/getgrupos")
    public List<Grupo> getAll() {
        return grupoRepo.findAll();
    }

    @GetMapping("/grupo/{id}")
    public Grupo getById(@PathVariable Long id) {
        return grupoRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/grupo/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        grupoRepo.deleteById(id);
    }

    @PostMapping("/grupo/save")
    public Grupo save(@RequestBody Grupo grupo) {
        return grupoRepo.save(grupo);
    }

    @PutMapping("/grupo/update{id}")
    public Grupo update(@RequestBody Grupo grupo, @PathVariable Long id) {
        Grupo grupoUpdate = grupoRepo.findById(id).orElseThrow();
        grupoUpdate.setGrado(grupo.getGrado());
        return grupoRepo.save(grupoUpdate);
    }


}
