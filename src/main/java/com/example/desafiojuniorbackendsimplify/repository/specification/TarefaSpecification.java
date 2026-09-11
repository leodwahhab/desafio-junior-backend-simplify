package com.example.desafiojuniorbackendsimplify.repository.specification;

import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import org.springframework.data.jpa.domain.Specification;

public class TarefaSpecification {
    public static Specification<Tarefa> nomeContem(String nome) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
    }

    public static Specification<Tarefa> descricaoContem(String descricao) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")), "%" + descricao + "%"));
    }

    public static Specification<Tarefa> porPrioridade(PrioridadeEnum prioridade) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("prioridade"), prioridade));
    }

    public static Specification<Tarefa> porRealizado(boolean realizado) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("realizado"), realizado));
    }

}
