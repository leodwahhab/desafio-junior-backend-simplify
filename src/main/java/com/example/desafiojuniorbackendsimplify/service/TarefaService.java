package com.example.desafiojuniorbackendsimplify.service;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;

import java.util.List;

public interface TarefaService {
    TarefaResponseDto criarTarefa(TarefaRequestDto dto);

    List<TarefaResponseDto> listarTarefas(TarefaRequestDto dto);

    Tarefa atualizarTarefa(Long id, TarefaRequestDto dto);

    void excluirTarefa(Long id);
}
