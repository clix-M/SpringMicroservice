package com.microservice.colegio.ctroller;

import com.microservice.colegio.models.Maestro;
import com.microservice.colegio.persistence.MaestroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colegio")
public class MaestroCrt {
    @Autowired
    private MaestroRepo maestroRepo;

    @GetMapping("/getmaestros")
    public List<Maestro> getAll(){
        return maestroRepo.findAll();
    }

    @GetMapping("/maestro/{id}")
    public Maestro getById(@PathVariable Long id){
        return maestroRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/maestro/delete/{id}")
    public void deleteById(@PathVariable Long id){
        maestroRepo.deleteById(id);
    }

    @PostMapping("/maestro/save")
    public Maestro save(@RequestBody Maestro maestro){
        return maestroRepo.save(maestro);
    }


    @PutMapping("/maestro/update{id}")
    public Maestro update(@RequestBody Maestro maestro, @PathVariable Long id){
        Maestro maestroUpdate = maestroRepo.findById(id).orElseThrow();
        maestroUpdate.setNombreCompleto(maestro.getNombreCompleto());
        maestroUpdate.setDireccion(maestro.getDireccion());
        maestroUpdate.setTelefono(maestro.getTelefono());
        maestroUpdate.setCorreo(maestro.getCorreo());
        maestroUpdate.setCURP(maestro.getCURP());
        maestroUpdate.setRFC(maestro.getRFC());
        maestroUpdate.setAsignatura(maestro.getAsignatura());
        return maestroRepo.save(maestroUpdate);
    }
}
