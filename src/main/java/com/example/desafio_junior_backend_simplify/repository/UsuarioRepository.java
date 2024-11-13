package com.example.desafio_junior_backend_simplify.repository;

import com.example.desafio_junior_backend_simplify.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsById(Long id);

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);

    List<Usuario> findAll();


}
