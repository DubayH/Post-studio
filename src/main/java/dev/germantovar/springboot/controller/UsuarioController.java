package dev.germantovar.springboot.controller;

import dev.germantovar.springboot.dto.LoginRequest;
import dev.germantovar.springboot.dto.LoginResponse;
import dev.germantovar.springboot.entities.Usuario;
import dev.germantovar.springboot.repository.UsuarioRepository;
import dev.germantovar.springboot.dto.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuario != null && usuario.getContraseña().equals(request.getContraseña())) {
            String token = JwtUtil.generateToken(usuario.getUsuario());
            return new LoginResponse(true, "Inicio de sesión exitoso", token);
        } else {
            return new LoginResponse(false, "Credenciales incorrectas", null);
        }
    }

}