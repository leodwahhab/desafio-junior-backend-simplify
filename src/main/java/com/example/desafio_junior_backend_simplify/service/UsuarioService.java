package com.example.desafio_junior_backend_simplify.service;

import com.example.desafio_junior_backend_simplify.dto.UsuarioDTO;


public interface UsuarioService {
    UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO buscarPorEmail(String email);

//    boolean validarLogin(String email, String senha);

}
