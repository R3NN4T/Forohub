package com.aluracursos.forohub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutenticacionUsuarioDTO(
        @NotBlank @Email String email,
        @NotBlank String contrasenia
) {
}