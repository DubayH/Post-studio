package dev.germantovar.springboot.repository;

import dev.germantovar.springboot.entities.Estudiantes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiantesRepository extends CrudRepository<Estudiantes, Long> {

}
