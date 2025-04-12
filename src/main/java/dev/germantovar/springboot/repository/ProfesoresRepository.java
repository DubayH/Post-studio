package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesoresRepository extends JpaRepository<Profesores, Long> {
    List<Profesores> findByEstudianteId(Long estudianteId);
}
