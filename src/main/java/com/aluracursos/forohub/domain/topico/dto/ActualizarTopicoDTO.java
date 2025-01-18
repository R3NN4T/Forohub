package com.aluracursos.forohub.domain.topico.dto;


import com.aluracursos.forohub.domain.topico.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  ActualizarTopicoDTO (
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Estado estado

){
}