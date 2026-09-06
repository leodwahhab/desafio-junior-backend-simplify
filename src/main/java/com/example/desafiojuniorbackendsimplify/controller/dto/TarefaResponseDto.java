package com.example.desafiojuniorbackendsimplify.controller.dto;

import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;

public record TarefaResponseDto(Long id, String nome, String descricao, boolean realizado, PrioridadeEnum prioridade) {
}
