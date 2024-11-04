package com.example.desafio_junior_backend_simplify.repository;

import com.example.desafio_junior_backend_simplify.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsById(Long id);

    Usuario getUsuarioByEmail(String email);

    boolean existsByEmail(String email);

//    boolean signIn(String email, String password);
}
