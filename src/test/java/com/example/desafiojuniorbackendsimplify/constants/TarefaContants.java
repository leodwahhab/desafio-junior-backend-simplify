package com.example.desafiojuniorbackendsimplify.constants;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;

public class TarefaContants {
    public static final TarefaRequestDto REQUEST_VALIDO = new TarefaRequestDto("Nome", "Descricao", false, PrioridadeEnum.MEDIA);
    public static final TarefaRequestDto REQUEST_VALIDO_CAMPOS_NULOS = new TarefaRequestDto("Nome", null, false, PrioridadeEnum.MEDIA);

    public static final TarefaResponseDto RESPONSE_VALIDO = new TarefaResponseDto(1L,"Nome", "Descricao", false, PrioridadeEnum.MEDIA);

    public static final Tarefa TAREFA_VALIDO = Tarefa.builder()
            .nome("Nome")
            .descricao("Descricao")
            .realizado(false)
            .prioridade(PrioridadeEnum.MEDIA)
            .build();
    public static final Tarefa TAREFA_EMPTY = Tarefa.builder()
            .nome("")
            .descricao("")
            .build();
    public static final Tarefa TAREFA_BLANK = Tarefa.builder()
            .nome(" ")
            .descricao(" ")
            .build();
    public static final Tarefa TAREFA_NULL = new Tarefa();

    public static final TarefaRequestDto REQUEST_EMPTY = new TarefaRequestDto("", "", false, PrioridadeEnum.MEDIA);
    public static final TarefaRequestDto REQUEST_BLANK = new TarefaRequestDto(" ", " ", false, PrioridadeEnum.MEDIA);
    public static final TarefaRequestDto REQUEST_NULL = new TarefaRequestDto(null, null, false, null);

}
