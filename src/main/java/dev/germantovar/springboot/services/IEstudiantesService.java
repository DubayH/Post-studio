package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Estudiantes;

import java.util.List;

public interface IEstudiantesService {
    List<Estudiantes> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

}
