package dev.germantovar.springboot.controller;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import dev.germantovar.springboot.entities.Profesores;
import dev.germantovar.springboot.services.ProfesoresService;
import dev.germantovar.springboot.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class DatosController {

    @Autowired
    private ProfesoresRepository profesoresRepository;

    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping("/estudiante/{estudianteId}")
    public List<Profesores> obtenerProfesoresPorEstudiante(@PathVariable Long estudianteId) {
        return profesoresRepository.findByEstudianteId(estudianteId);
    }

    @PostMapping("/estudiante/{estudianteId}/agregar")
    public Profesores agregarProfesor(@PathVariable Long estudianteId, @RequestBody Profesores profesor) {
        return profesoresService.save(estudianteId, profesor);

    }
    // se realiza comentario
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesores> actualizarProfesor(@PathVariable("id") Long id, @RequestBody Profesores profesor) {
        Optional<Profesores> profesorData = profesoresRepository.findById(id);

        if (profesorData.isPresent()) {
            Profesores profesor1 = profesorData.get();
            profesor1.setNombre(profesor.getNombre());
            profesor1.setApellido(profesor.getApellido());
            profesor1.setMateria(profesor.getMateria());
            profesor1.setContraseña(profesor.getContraseña());

            return new ResponseEntity<>(profesoresRepository.save(profesor1), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}


