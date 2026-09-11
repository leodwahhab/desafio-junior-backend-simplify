package com.example.desafiojuniorbackendsimplify.service.impl;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.exception.TarefaJaExistenteException;
import com.example.desafiojuniorbackendsimplify.mapper.TarefaMapper;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import com.example.desafiojuniorbackendsimplify.repository.TarefaRepository;
import com.example.desafiojuniorbackendsimplify.repository.specification.TarefaSpecification;
import com.example.desafiojuniorbackendsimplify.service.TarefaService;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    public List<TarefaResponseDto> listarTarefas(TarefaRequestDto dto) {
        Specification<Tarefa> specification = Specification.unrestricted();

        if(dto.nome() != null && !dto.nome().isBlank()) {
            specification = specification.and(TarefaSpecification.nomeContem(dto.nome()));
        }

        if(dto.descricao() != null && !dto.descricao().isBlank()) {
            specification = specification.and(TarefaSpecification.descricaoContem(dto.descricao()));
        }

        if(dto.realizado() != null) {
            specification = specification.and(TarefaSpecification.porRealizado(dto.realizado()));
        }

        if ((dto.prioridade() != null)) {
            specification = specification.and(TarefaSpecification.porPrioridade(dto.prioridade()));
        }

        return tarefaMapper.toDtoLista(tarefaRepository.findAll(specification));
    }

    @Override
    public TarefaResponseDto atualizarTarefa(Long id, TarefaRequestDto dto) {
        Tarefa tarefa = tarefaMapper.toTarefa(dto);
        tarefa.setId(id);
        return tarefaMapper.toDto(tarefaRepository.save(tarefa));
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
