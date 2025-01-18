package com.aluracursos.forohub.domain.usuario.repository;

import com.aluracursos.forohub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Encontrar por E-mail
    Optional<Usuario> findByEmail(String email);

}
