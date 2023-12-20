package com.microservice.colegio.ctroller;

import com.microservice.colegio.models.TipoParentesco;
import com.microservice.colegio.persistence.TipoParentescoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class TipoParentescoCtro {
    @Autowired
    private TipoParentescoRepo tipoParentescoRepo;

    @GetMapping("/gettipoparentescos")
    private List<TipoParentesco> getAll(){
        return tipoParentescoRepo.findAll();
    }

    @GetMapping("/parentesco/{id}")
    private TipoParentesco getById(@PathVariable Long id){
        return tipoParentescoRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/parentesco/delete/{id}")
    private void deleteById(@PathVariable Long id){
        tipoParentescoRepo.deleteById(id);
    }

    @PostMapping("/parentesco/save")
    private TipoParentesco save(@RequestBody TipoParentesco tipoParentesco){
        return tipoParentescoRepo.save(tipoParentesco);
    }

    @PutMapping("/parentesco/update/{id}")
    private void update(@PathVariable Long id, @RequestBody TipoParentesco tipoParentesco){
        TipoParentesco tipoParentescoUpdate = tipoParentescoRepo.findById(id).orElseThrow();
        tipoParentescoUpdate.setDescripcion(tipoParentesco.getDescripcion());
        tipoParentescoRepo.save(tipoParentescoUpdate);
    }

}
