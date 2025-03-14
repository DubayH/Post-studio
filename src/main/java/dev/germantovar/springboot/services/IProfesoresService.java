package dev.germantovar.springboot.services;

import dev.germantovar.springboot.entities.Profesores;

import java.util.List;

public interface IProfesoresService {
    List<Profesores> getAll();
}
