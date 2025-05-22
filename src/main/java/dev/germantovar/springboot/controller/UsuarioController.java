package dev.germantovar.springboot.controller;

import  dev.germantovar.springboot.dto.LoginRequest;
import dev.germantovar.springboot.dto.LoginResponse;
import dev.germantovar.springboot.entities.Usuario;
import dev.germantovar.springboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public LoginResponse login(@ModelAttribute LoginRequest request) {
        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuario != null && usuario.getContraseña().equals(request.getContraseña())) {
            return new LoginResponse(true, "Inicio de sesión exitoso");
        } else {
            return new LoginResponse(false, "Credenciales incorrectas");
        }
    }
}
