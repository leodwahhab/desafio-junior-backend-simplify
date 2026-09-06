package com.example.desafiojuniorbackendsimplify.mapper;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TarefaMapper {
    public TarefaResponseDto toDto(Tarefa tarefa) {
        return new TarefaResponseDto(
                tarefa.getId(),
                tarefa.getNome(),
                tarefa.getDescricao(),
                tarefa.isRealizado(),
                tarefa.getPrioridade()
        );
    }

    public List<TarefaResponseDto> toDtoLista(List<Tarefa> tarefas) {
        return tarefas.stream().map(this::toDto).toList();
    }

    public Tarefa toTarefa(TarefaRequestDto dto) {
        return Tarefa.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .realizado(dto.realizado())
                .prioridade(dto.prioridade())
                .build();
    }
}
