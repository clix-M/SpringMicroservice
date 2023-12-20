package com.mocroservice.course.mocroservicecourse.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class AlumnoDTO {
    private int idAlumno;
    private String nombreCompleto;
    private String genero;
    private String curp;
    private String fechaNac;
    private String direccion;
    private String telefono;

    private Set<Calificacion> calificaciones = new HashSet<>();

}
