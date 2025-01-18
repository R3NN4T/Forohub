package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.usuario.dto.AutenticacionUsuarioDTO;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.repository.UsuarioRepository;
import com.aluracursos.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(UsuarioRepository usuarioRepository, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<String> autenticar(@RequestBody @Valid AutenticacionUsuarioDTO datos) {
        Usuario usuario = usuarioRepository.findByEmail(datos.email())
                .orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas."));

        if (!passwordEncoder.matches(datos.contrasenia(), usuario.getContrasenia())) {
            throw new IllegalArgumentException("Credenciales inválidas.");
        }

        String token = tokenService.generarToken(usuario);
        return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
    }
}
