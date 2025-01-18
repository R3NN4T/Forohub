package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.usuario.dto.*;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.repository.UsuarioRepository;
import com.aluracursos.forohub.domain.usuario.validations.create.ValidarCrearUsuario;
import com.aluracursos.forohub.domain.usuario.validations.update.ValidarActualizarUsuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private final List<ValidarCrearUsuario> validacionesCrear;
    private final List<ValidarActualizarUsuario> validacionesActualizar;

    public UsuarioController(UsuarioRepository usuarioRepository,
                             List<ValidarCrearUsuario> validacionesCrear,
                             List<ValidarActualizarUsuario> validacionesActualizar) {
        this.usuarioRepository = usuarioRepository;
        this.validacionesCrear = validacionesCrear;
        this.validacionesActualizar = validacionesActualizar;
    }

    @PostMapping
    public ResponseEntity<DetallesUsuarioDTO> crearUsuario(@RequestBody @Valid CrearUsuarioDTO datos) {
        validacionesCrear.forEach(validacion -> validacion.validar(datos));
        Usuario usuario = new Usuario();
        usuario.setNombre(datos.nombre());
        usuario.setEmail(datos.email());
        usuario.setContrasenia(datos.contrasenia());
        usuario.setRole(datos.role());
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DetallesUsuarioDTO(
                usuarioGuardado.getId(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getRole()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesUsuarioDTO> actualizarUsuario(@PathVariable Long id,
                                                                @RequestBody @Valid ActualizarUsuarioDTO datos) {
        datos = new ActualizarUsuarioDTO(id, datos.nombre(), datos.contrasenia());
        @Valid ActualizarUsuarioDTO finalDatos = datos;
        validacionesActualizar.forEach(validacion -> validacion.validar(finalDatos));
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));
        usuario.setNombre(datos.nombre());
        usuario.setContrasenia(datos.contrasenia());
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DetallesUsuarioDTO(
                usuarioActualizado.getId(),
                usuarioActualizado.getNombre(),
                usuarioActualizado.getEmail(),
                usuarioActualizado.getRole()
        ));
    }

    @GetMapping
    public ResponseEntity<List<DetallesUsuarioDTO>> listarUsuarios() {
        List<DetallesUsuarioDTO> usuarios = usuarioRepository.findAll()
                .stream()
                .map(usuario -> new DetallesUsuarioDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getEmail(),
                        usuario.getRole()
                )).toList();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesUsuarioDTO> obtenerUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));
        return ResponseEntity.ok(new DetallesUsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRole()
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
