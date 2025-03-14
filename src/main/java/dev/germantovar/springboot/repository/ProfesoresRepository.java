package dev.germantovar.springboot.repository;


import dev.germantovar.springboot.entities.Profesores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesoresRepository extends CrudRepository<Profesores, Long> {

}
