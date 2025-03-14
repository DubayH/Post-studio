package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.entities.Profesores;
import dev.germantovar.springboot.repository.EstudiantesRepository;
import dev.germantovar.springboot.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesoresService implements IProfesoresService {
    @Autowired
    private ProfesoresRepository repository;
    @Override
    public List<Profesores> getAll(){
        return (List<Profesores>) repository.findAll();
    }



}
