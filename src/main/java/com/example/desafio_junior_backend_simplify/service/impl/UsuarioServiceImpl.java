package com.example.desafio_junior_backend_simplify.service.impl;

import com.example.desafio_junior_backend_simplify.dto.UsuarioDTO;
import com.example.desafio_junior_backend_simplify.model.Usuario;
import com.example.desafio_junior_backend_simplify.repository.UsuarioRepository;
import com.example.desafio_junior_backend_simplify.service.UsuarioService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
        if(usuarioNaoNulo(usuarioDTO))
            throw new InvalidParameterException();

        if(usuarioRepository.existsByEmail(usuarioDTO.email()))
            throw new EntityExistsException();

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuarioRepository.save(usuario);

        return usuarioDTO;

    }

    public UsuarioDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.getUsuarioByEmail(email);

        if(usuario == null)
            return null;

        return new UsuarioDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }

    public boolean validarLogin(String email, String senha) {
        Usuario usuario = usuarioRepository.getUsuarioByEmail(email);

        return Objects.nonNull(usuario) && usuario.getSenha().equals(senha);
    }

    private boolean usuarioNaoNulo(UsuarioDTO usuarioDTO) {
        return Objects.isNull(usuarioDTO) || Objects.isNull(usuarioDTO.nome()) || Objects.isNull(usuarioDTO.email()) || Objects.isNull(usuarioDTO.senha());
    }
}
