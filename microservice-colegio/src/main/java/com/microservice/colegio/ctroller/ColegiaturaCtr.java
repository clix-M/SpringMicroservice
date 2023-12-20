package com.microservice.colegio.ctroller;


import com.microservice.colegio.models.Colegiatura;
import com.microservice.colegio.persistence.ColegiaturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class ColegiaturaCtr {
    @Autowired
    private ColegiaturaRepo colegiaturaRepo;

    @GetMapping("/getcolegiaturas")
    private List<Colegiatura> getAll(){
        return colegiaturaRepo.findAll();
    }

    @GetMapping("/colegiatura/{id}")
    private Colegiatura getById(@PathVariable Long id){
        return colegiaturaRepo.findById(id).get();
    }

    @DeleteMapping("/colegiatura/delete/{id}")
    private void deleteById(@PathVariable Long id){
        colegiaturaRepo.deleteById(id);
    }

    @PostMapping("/colegiatura/save")
    private Colegiatura save(@RequestBody Colegiatura colegiatura){
        colegiaturaRepo.save(colegiatura);
        return colegiatura;
    }
    @PutMapping("/colegiatura/update/{id}")
    private void update(@PathVariable Long id, @RequestBody Colegiatura colegiatura){
           Colegiatura colegiaturaUpdate = colegiaturaRepo.findById(id).orElseThrow();
            colegiaturaUpdate.setMonto(colegiatura.getMonto());
            colegiaturaUpdate.setMes(colegiatura.getMes());
            colegiaturaUpdate.setPagada(colegiatura.getPagada());
            colegiaturaRepo.save(colegiaturaUpdate);

    }
}
