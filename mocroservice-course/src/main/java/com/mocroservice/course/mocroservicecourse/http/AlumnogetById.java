package com.mocroservice.course.mocroservicecourse.http;

import com.mocroservice.course.mocroservicecourse.dto.AlumnoDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AlumnogetById {
    private String asignatura;
    private String calificacion;
    private List<AlumnoDTO> alumnoDTOList;


}
