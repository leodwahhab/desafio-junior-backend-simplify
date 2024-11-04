package com.example.desafio_junior_backend_simplify.dto;

import com.example.desafio_junior_backend_simplify.model.Usuario;

public record TarefaDTO(String nome, String descricao, boolean realizado, int prioridade) {
}
