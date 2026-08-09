package com.banco.miplata.repositories;

import com.banco.miplata.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByIdentificacion(String identificacion);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByIdentificacion(String identificacion);
}
