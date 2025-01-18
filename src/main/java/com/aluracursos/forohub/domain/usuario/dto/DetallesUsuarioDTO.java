package com.aluracursos.forohub.domain.usuario.dto;

import com.aluracursos.forohub.domain.usuario.Role;
import com.aluracursos.forohub.domain.usuario.Usuario;


public record DetallesUsuarioDTO(
        Long id,
        String nombre,
        String emaol,
        Role role
) {
}
