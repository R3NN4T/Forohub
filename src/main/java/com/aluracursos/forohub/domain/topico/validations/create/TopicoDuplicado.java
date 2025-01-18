package com.aluracursos.forohub.domain.topico.validations.create;


import com.aluracursos.forohub.domain.topico.dto.CrearTopicoDTO;
import com.aluracursos.forohub.domain.topico.repository.TopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidarTopicoCreado{

    private final TopicoRepository topicoRepository;

    public TopicoDuplicado(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }


    @Override
    public void validar(CrearTopicoDTO datos) {
        boolean existe = topicoRepository.findAll().stream()
                .anyMatch(topico -> topico.getTitulo().equals(datos.titulo()));
        if (existe) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título.");
        }
    }
}
