package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.repository.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesService implements IEstudiantesService {
    @Autowired
    private EstudiantesRepository repository;

    @Override
    public List<Estudiantes> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}





