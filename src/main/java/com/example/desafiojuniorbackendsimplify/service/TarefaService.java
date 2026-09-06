package com.example.desafiojuniorbackendsimplify.service;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;

import java.util.List;

public interface TarefaService {
    Tarefa criarTarefa(TarefaRequestDto dto);

    List<TarefaResponseDto> listarTarefas();

    Tarefa atualizarTarefa(TarefaRequestDto dto);

    void excluirTarefa(Long id);
}
