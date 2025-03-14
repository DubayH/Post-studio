package dev.germantovar.springboot.controller;

import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.entities.Profesores;
import dev.germantovar.springboot.repository.EstudiantesRepository;
import dev.germantovar.springboot.repository.ProfesoresRepository;
import dev.germantovar.springboot.services.IEstudiantesService;
import dev.germantovar.springboot.services.IProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProfesoresController {
    @Autowired
    private IProfesoresService service1;

    @Autowired
    private ProfesoresRepository customerRepository;

    @GetMapping("customerlista")
    public List<Profesores> getAll() {
        return service1.getAll();
    }
}
