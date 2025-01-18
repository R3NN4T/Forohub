package com.aluracursos.forohub.domain.usuario;

import com.aluracursos.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Table(name= "usuario")
@Entity(name= "Usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String contrasenia;


    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;

    public @NotBlank Role getRol() {
        return rol;
    }

    public void setRol(@NotBlank Role rol) {
        this.rol = rol;
    }

    public List<Topico> getTopico() {
        return topico;
    }

    public void setTopico(List<Topico> topico) {
        this.topico = topico;
    }

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role rol;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topico;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Role getRole() {
        return rol;
    }

    public void setRole(Role rol) {
        this.rol = rol;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Si no tienes roles implementados, puedes devolver una lista vacía.
        return List.of( new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.contrasenia;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Cambiar según tu lógica de negocio
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Cambiar según tu lógica de negocio
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Cambiar según tu lógica de negocio
    }

    @Override
    public boolean isEnabled() {
        return true; // Cambiar según tu lógica de negocio
    }
}
