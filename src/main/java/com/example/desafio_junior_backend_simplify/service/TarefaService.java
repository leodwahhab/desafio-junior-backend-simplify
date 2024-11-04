package com.example.desafio_junior_backend_simplify.service;

import com.example.desafio_junior_backend_simplify.dto.TarefaDTO;

import java.util.List;

public interface TarefaService {

    List<TarefaDTO> listarTarefas(Long usuarioId);

    TarefaDTO criarTarefa(String email, String senha, TarefaDTO tarefaDTO);

    void excluirTarefa(Long id);

}
