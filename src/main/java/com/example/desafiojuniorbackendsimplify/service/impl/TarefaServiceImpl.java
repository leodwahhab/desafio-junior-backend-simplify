package com.example.desafiojuniorbackendsimplify.service.impl;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.mapper.TarefaMapper;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import com.example.desafiojuniorbackendsimplify.repository.TarefaRepository;
import com.example.desafiojuniorbackendsimplify.service.TarefaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaMapper tarefaMapper;
    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaMapper tarefaMapper, TarefaRepository tarefaRepository) {
        this.tarefaMapper = tarefaMapper;
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public TarefaResponseDto criarTarefa(TarefaRequestDto dto) {
        Tarefa tarefa = tarefaMapper.toTarefa(dto);

        // TODO verificar se tarefa já existe (tornar nome único OU (nome + realizado = false) único)

        return tarefaMapper.toDto(tarefaRepository.save(tarefa));
    }

    @Override
    public List<TarefaResponseDto> listarTarefas() {
        return tarefaMapper.toDtoLista(tarefaRepository.findAll());
    }

    @Override
    public Tarefa atualizarTarefa(Long id, TarefaRequestDto dto) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(
                // TODO tratar exceção
                () -> new NoSuchElementException("Tarefa não registrada")
        );

        tarefa.setNome(dto.nome());
        tarefa.setDescricao(dto.descricao());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setRealizado(dto.realizado());

        return tarefaRepository.save(tarefa);
    }

    @Override
    public void excluirTarefa(Long id) {

    }
}
