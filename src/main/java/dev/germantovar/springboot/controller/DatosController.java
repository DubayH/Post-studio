package dev.germantovar.springboot.controller;
import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.entities.Profesores;
import dev.germantovar.springboot.services.IEstudiantesService;
import dev.germantovar.springboot.services.IProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/datos")
public class DatosController {
    @Autowired
    private IEstudiantesService estudiantesService;

    @Autowired
    private IProfesoresService profesoresService;

    @GetMapping("/lista")
    public Map<String, Object> getDatosCompletos() {
        List<Estudiantes> estudiantes = estudiantesService.getAll();
        List<Profesores> profesores = profesoresService.getAll();

        Map<String, Object> response = new HashMap<>();
        response.put("estudiantes", estudiantes);
        response.put("profesores", profesores);

        return response;
    }
}

