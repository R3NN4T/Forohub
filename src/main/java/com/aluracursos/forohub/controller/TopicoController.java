package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.dto.*;
import com.aluracursos.forohub.domain.topico.repository.TopicoRepository;
import com.aluracursos.forohub.domain.topico.validations.create.ValidarTopicoCreado;
import com.aluracursos.forohub.domain.topico.validations.update.ValidarTopicoActualizado;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final List<ValidarTopicoCreado> validacionesCrear;
    private final List<ValidarTopicoActualizado> validacionesActualizar;

    public TopicoController(TopicoRepository topicoRepository,
                            UsuarioRepository usuarioRepository,
                            List<ValidarTopicoCreado> validacionesCrear,
                            List<ValidarTopicoActualizado> validacionesActualizar) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.validacionesCrear = validacionesCrear;
        this.validacionesActualizar = validacionesActualizar;
    }

    @PostMapping
    public ResponseEntity<DetallesTopicoDTO> crearTopico(@RequestBody @Valid CrearTopicoDTO datos) {
        validacionesCrear.forEach(validacion -> validacion.validar(datos));

        Usuario autor = usuarioRepository.findByEmail(datos.autorEmail())
                .orElseThrow(() -> new IllegalArgumentException("El usuario autor no existe."));

        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(autor);
        topico.setEstado(datos.estado());

        Topico topicoGuardado = topicoRepository.save(topico);

        return ResponseEntity.ok(new DetallesTopicoDTO(
                topicoGuardado.getId(),
                topicoGuardado.getTitulo(),
                topicoGuardado.getMensaje(),
                topicoGuardado.getEstado(),
                topicoGuardado.getAutor().getId(),
                topicoGuardado.getFechaCreacion()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesTopicoDTO> actualizarTopico(@PathVariable Long id,
                                                             @RequestBody @Valid ActualizarTopicoDTO datos) {
        datos = new ActualizarTopicoDTO(id, datos.titulo(), datos.mensaje(), datos.estado());
        @Valid ActualizarTopicoDTO finalDatos = datos;
        validacionesActualizar.forEach(validacion -> validacion.validar(finalDatos));

        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado."));

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setEstado(datos.estado());

        Topico topicoActualizado = topicoRepository.save(topico);

        return ResponseEntity.ok(new DetallesTopicoDTO(
                topicoActualizado.getId(),
                topicoActualizado.getTitulo(),
                topicoActualizado.getMensaje(),
                topicoActualizado.getEstado(),
                topicoActualizado.getAutor().getId(),
                topicoActualizado.getFechaCreacion()
        ));

    }

    @GetMapping
    public ResponseEntity<List<DetallesTopicoDTO>> listarTopicos() {
        List<DetallesTopicoDTO> topicos = topicoRepository.findAll()
                .stream()
                .map(topico -> new DetallesTopicoDTO(
                        topico.getId(),
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getEstado(),
                        topico.getAutor().getId(),
                        topico.getFechaCreacion()
                ))
                .toList();

        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesTopicoDTO> obtenerTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado."));

        return ResponseEntity.ok(new DetallesTopicoDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado(),
                topico.getAutor().getId(),
                topico.getFechaCreacion()
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado.");
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
