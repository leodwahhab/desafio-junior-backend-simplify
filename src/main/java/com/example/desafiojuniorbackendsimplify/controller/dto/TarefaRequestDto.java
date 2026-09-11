package com.example.desafiojuniorbackendsimplify.controller.dto;

import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TarefaRequestDto(@NotBlank @NotNull String nome, String descricao, Boolean realizado, @NotNull PrioridadeEnum prioridade) {
}
