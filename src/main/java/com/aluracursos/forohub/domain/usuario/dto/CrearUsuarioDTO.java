package com.aluracursos.forohub.domain.usuario.dto;

import com.aluracursos.forohub.domain.usuario.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioDTO(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String contrasenia,
        @NotBlank Role role
        ) {
}
