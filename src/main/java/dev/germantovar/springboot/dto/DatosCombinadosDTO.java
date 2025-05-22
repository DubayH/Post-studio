package dev.germantovar.springboot.dto;

import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.entities.Profesores;
import java.util.List;

public class DatosCombinadosDTO {
    private List<Estudiantes> estudiantes;
    private List<Profesores> profesores;

    public DatosCombinadosDTO(List<Estudiantes> estudiantes, List<Profesores> profesores) {
        this.estudiantes = estudiantes;
        this.profesores = profesores;
    }

    public List<Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    public List<Profesores> getProfesores() {
        return profesores;
    }
}

