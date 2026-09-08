package com.example.desafiojuniorbackendsimplify.constants;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.mapper.TarefaMapper;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;

public class TarefaContants {
    public static final TarefaRequestDto REQUEST_VALIDO = new TarefaRequestDto("Nome", "Descricao", false, PrioridadeEnum.MEDIA);
    public static final TarefaRequestDto REQUEST_VALIDO_CAMPOS_NULOS = new TarefaRequestDto("Nome", null, false, PrioridadeEnum.MEDIA);

    public static final TarefaResponseDto RESPONSE_VALIDO = new TarefaResponseDto(1L,"Nome", "Descricao", false, PrioridadeEnum.MEDIA);
    public static final TarefaResponseDto RESPONSE_VALIDO_CAMPOS_NULOS = new TarefaResponseDto(1L,"Nome", "Descricao", false,PrioridadeEnum.MEDIA);

    public static final Tarefa TAREFA_VALIDO = Tarefa.builder()
            .id(1L)
            .nome("Nome")
            .descricao("Descricao")
            .realizado(false)
            .prioridade(PrioridadeEnum.MEDIA)
            .build();
    public static final Tarefa TAREFA_VALIDO_CAMPOS_NULOS = Tarefa.builder()
            .id(1L)
            .nome("Nome")
            .prioridade(PrioridadeEnum.MEDIA)
            .build();

//    public static final Tarefa TAREFA_VALIDO = new TarefaMapper().toTarefa(REQUEST_VALIDO);
//    public static final Tarefa TAREFA_VALIDO = new TarefaMapper().toTarefa(REQUEST_VALIDO);
}
