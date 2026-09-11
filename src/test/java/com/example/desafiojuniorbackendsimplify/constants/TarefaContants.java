package com.example.desafiojuniorbackendsimplify.constants;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.mapper.TarefaMapper;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;

import java.util.List;

public class TarefaContants {
    public static TarefaRequestDto REQUEST_VALIDO = new TarefaRequestDto("Passear com o cachorro","Levar o cachorro para passear antes do anoitecer", false, PrioridadeEnum.MEDIA);
//    public static TarefaRequestDto REQUEST_VALIDO_CAMPOS_NULOS = new TarefaRequestDto("Nome", null, false, PrioridadeEnum.MEDIA);
    public static TarefaRequestDto REQUEST_EMPTY = new TarefaRequestDto("", "", false, PrioridadeEnum.MEDIA);
    public static TarefaRequestDto REQUEST_BLANK = new TarefaRequestDto(" ", " ", false, PrioridadeEnum.MEDIA);
    public static TarefaRequestDto REQUEST_NULL = new TarefaRequestDto(null, null, null, null);

    public static Tarefa getTarefaValido01() {
        return new TarefaMapper().toTarefa(REQUEST_VALIDO);
    }
    public static Tarefa getTarefaValido02() {
        return Tarefa.builder()
                .nome("Estudar para a prova de Cálculo I")
                .descricao("Ler capítulos 2 e 3 do livro e fazer a lista de exercícios")
                .realizado(false)
                .prioridade(PrioridadeEnum.ALTA)
                .build();
    }
    public static final Tarefa TAREFA_VALIDO_03 = Tarefa.builder()
            .nome("Comprar molho de tomate")
            .descricao("Ir ao mercado e comprar molho de tomate para fazer macarrão para o almoço")
            .realizado(true)
            .prioridade(PrioridadeEnum.ALTA)
            .build();
//    public static final Tarefa TAREFA_VALIDO_CAMPOS_NULOS = new TarefaMapper().toTarefa(REQUEST_VALIDO_CAMPOS_NULOS);

    public static final Tarefa TAREFA_EMPTY = Tarefa.builder()
            .nome("")
            .descricao("")
            .prioridade(PrioridadeEnum.MEDIA)
            .build();
    public static final Tarefa TAREFA_BLANK = Tarefa.builder()
            .nome(" ")
            .descricao(" ")
            .prioridade(PrioridadeEnum.MEDIA)
            .build();
    public static final Tarefa TAREFA_NULL = new Tarefa();

    public static final List<Tarefa> LISTA_TAREFAS = List.of(getTarefaValido01(), getTarefaValido02(), TAREFA_VALIDO_03);
    public static final List<Tarefa> LISTA_TAREFAS_FILTRADA = List.of(LISTA_TAREFAS.stream().findFirst().get());

    public static final TarefaResponseDto RESPONSE_VALIDO = new TarefaMapper().toDto(getTarefaValido01());
//    public static final TarefaResponseDto RESPONSE_VALIDO_CAMPOS_NULOS = new TarefaMapper().toDto(TAREFA_VALIDO_CAMPOS_NULOS);
}
