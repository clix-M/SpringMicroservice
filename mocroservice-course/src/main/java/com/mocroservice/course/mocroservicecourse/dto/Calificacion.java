package com.mocroservice.course.mocroservicecourse.dto;

import com.mocroservice.course.mocroservicecourse.entities.Asignatura;

public record Calificacion(int idCalificacion, String bimestre, String calificacion, Asignatura asignatura) {}