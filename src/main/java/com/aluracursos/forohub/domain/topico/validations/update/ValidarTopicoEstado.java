package com.aluracursos.forohub.domain.topico.validations.update;

import com.aluracursos.forohub.domain.topico.Estado;
import com.aluracursos.forohub.domain.topico.dto.ActualizarTopicoDTO;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoEstado {

    public void validar(ActualizarTopicoDTO datos) {
        if (datos.estado() != null && datos.estado() == Estado.CERRADO) {
            throw new IllegalArgumentException("No se puede actualizar un tópico cerrado.");
        }
    }
}

