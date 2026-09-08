package com.example.desafiojuniorbackendsimplify.service.impl;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.exception.TarefaJaExistenteException;
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
        if(tarefaRepository.existsByNomeAndRealizadoFalse(dto.nome())){
            throw new TarefaJaExistenteException();
        }

        Tarefa tarefa = tarefaMapper.toTarefa(dto);

        return tarefaMapper.toDto(tarefaRepository.save(tarefa));
    }

    @Override
    public List<TarefaResponseDto> listarTarefas() {
        return tarefaMapper.toDtoLista(tarefaRepository.findAll());
    }

    @Override
    public Tarefa atualizarTarefa(Long id, TarefaRequestDto dto) {
        Tarefa tarefa = findTarefaExistentePorId(id);

        tarefa = tarefaMapper.toTarefa(dto);

        return tarefaRepository.save(tarefa);
    }

    @Override
    public void excluirTarefa(Long id) {
        Tarefa tarefa = findTarefaExistentePorId(id);

        tarefaRepository.delete(tarefa);
    }

    private Tarefa findTarefaExistentePorId(Long id) {
        return tarefaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
