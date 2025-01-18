package com.aluracursos.forohub.domain.usuario.validations.update;


import com.aluracursos.forohub.domain.usuario.repository.UsuarioRepository;
import com.aluracursos.forohub.domain.usuario.dto.ActualizarUsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario {

    private final UsuarioRepository usuarioRepository;

    public ValidaActualizacionUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void validar(ActualizarUsuarioDTO datos) {
        boolean existe = usuarioRepository.findById(datos.id()).isEmpty();
        if (existe) {
            throw new IllegalArgumentException("El usuario a actualizar no existe.");
        }
    }
}
