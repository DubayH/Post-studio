package dev.germantovar.springboot.controller;
import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.repository.EstudiantesRepository;
import dev.germantovar.springboot.services.IEstudiantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EstudiantesController {
    @Autowired
    private IEstudiantesService service;

    @Autowired
    private EstudiantesRepository customerRepository;

    @GetMapping("customerlista")
    public List<Estudiantes> getAll() {
        return service.getAll();
    }
}
