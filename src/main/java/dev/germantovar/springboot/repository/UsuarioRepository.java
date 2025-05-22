package dev.germantovar.springboot.repository;


import dev.germantovar.springboot.entities.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);

    Usuario findByUsuarioAndContraseña(String usuario, String contraseña);
}

