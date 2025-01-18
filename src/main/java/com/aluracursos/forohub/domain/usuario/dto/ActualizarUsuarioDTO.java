package com.aluracursos.forohub.domain.usuario.dto;

import com.aluracursos.forohub.domain.usuario.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarUsuarioDTO(
        @NotNull Long id,
        @NotBlank String nombre,
        @NotBlank String contrasenia
) {
}
