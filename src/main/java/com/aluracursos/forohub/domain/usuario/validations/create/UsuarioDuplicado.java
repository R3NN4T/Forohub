package com.aluracursos.forohub.domain.usuario.validations.create;

import com.aluracursos.forohub.domain.usuario.repository.UsuarioRepository;
import com.aluracursos.forohub.domain.usuario.dto.CrearUsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDuplicado implements ValidarCrearUsuario {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDuplicado(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void validar(CrearUsuarioDTO datos) {
        boolean existe = usuarioRepository.findByEmail(datos.email()).isPresent();
        if (existe) {
            throw new IllegalArgumentException("Ya existe un usuario con este correo electrónico.");
        }
    }
}
