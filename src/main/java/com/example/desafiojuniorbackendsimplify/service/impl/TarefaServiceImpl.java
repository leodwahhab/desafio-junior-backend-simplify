package com.example.desafiojuniorbackendsimplify.service.impl;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.mapper.TarefaMapper;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import com.example.desafiojuniorbackendsimplify.repository.TarefaRepository;
import com.example.desafiojuniorbackendsimplify.service.TarefaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaMapper tarefaMapper;
    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaMapper tarefaMapper, TarefaRepository tarefaRepository) {
        this.tarefaMapper = tarefaMapper;
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa criarTarefa(TarefaRequestDto dto) {
        Tarefa tarefa = tarefaMapper.toTarefa(dto);

        // TODO verificar se tarefa já existe (tornar nome único OU (nome + realizado = false) único)

        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<TarefaResponseDto> listarTarefas() {
        return List.of();
    }

    @Override
    public Tarefa atualizarTarefa(TarefaRequestDto dto) {
        return null;
    }

    @Override
    public void excluirTarefa(Long id) {

    }
}
