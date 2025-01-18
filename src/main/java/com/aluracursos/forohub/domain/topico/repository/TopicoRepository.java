package com.aluracursos.forohub.domain.topico.repository;



import com.aluracursos.forohub.domain.topico.Estado;
import com.aluracursos.forohub.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Buscar tópicos por estado
    List<Topico> findByEstado(Estado estado);

    // Buscar tópicos por ID del autor
    List<Topico> findByAutorId(Long autor);

    // Si tienes consultas personalizadas:
    @Query("SELECT t FROM Topico t WHERE t.titulo = :titulo") // No requiere cambio
    List<Topico> buscarPorTitulo(@Param("titulo") String titulo);
}