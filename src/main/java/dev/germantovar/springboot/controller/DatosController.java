package dev.germantovar.springboot.controller;

import dev.germantovar.springboot.dto.DatosCombinadosDTO;
import dev.germantovar.springboot.entities.Estudiantes;
import dev.germantovar.springboot.entities.Profesores;
import dev.germantovar.springboot.repository.ProfesoresRepository;
import dev.germantovar.springboot.services.EstudiantesService;
import dev.germantovar.springboot.services.ProfesoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class DatosController {

    @Autowired
    private ProfesoresRepository profesoresRepository;

    @Autowired
    private ProfesoresService profesoresService;

    @Autowired
    private EstudiantesService estudiantesService;

    @GetMapping("/estudiante/{estudianteId}")
    public List<Profesores> obtenerProfesoresPorEstudiante(@PathVariable Long estudianteId) {
        return profesoresRepository.findByEstudianteId(estudianteId);
    }

    @PostMapping("/estudiante/{estudianteId}/agregar")
    public Profesores agregarProfesor(@PathVariable Long estudianteId, @RequestBody Profesores profesor) {
        return profesoresService.save(estudianteId, profesor);
    }

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

    @GetMapping("/todos")
    public DatosCombinadosDTO obtenerTodos() {
        List<Estudiantes> estudiantes = estudiantesService.getAll();
        List<Profesores> profesores = profesoresRepository.findAll();
        return new DatosCombinadosDTO(estudiantes, profesores);
    }

    @RestController
    @RequestMapping("/api/estudiantes")
    public class EstudiantesController {
        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
            if (estudiantesService.existsById(id)) {
                estudiantesService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}
