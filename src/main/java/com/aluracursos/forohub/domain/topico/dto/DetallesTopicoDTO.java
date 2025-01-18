package com.aluracursos.forohub.domain.topico.dto;

import com.aluracursos.forohub.domain.topico.Estado;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO para mostrar los detalles de un tópico.
 * Proporciona información completa de un tópico.
 */
public record DetallesTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        Estado estado,
        Long autor,
        LocalDateTime fechaCreacion
) {
}
