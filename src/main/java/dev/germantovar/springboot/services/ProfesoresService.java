package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.entities.Profesores;
import dev.germantovar.springboot.repository.EstudiantesRepository;
import dev.germantovar.springboot.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesoresService {

    @Autowired
    private ProfesoresRepository profesoresRepository;

    @Autowired
    private EstudiantesRepository estudiantesRepository;

    public Profesores save(Long estudianteId, Profesores profesor) {
        Estudiantes estudiante = estudiantesRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        profesor.setEstudiante(estudiante);
        return profesoresRepository.save(profesor);
    }
}

