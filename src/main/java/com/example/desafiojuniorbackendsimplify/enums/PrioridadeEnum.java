package com.example.desafiojuniorbackendsimplify.enums;

import lombok.Getter;

@Getter
public enum PrioridadeEnum {
    BAIXA("Baixa"),
    MEDIA("Média"),
    ALTA("Alta");

    private final String descricao;

    PrioridadeEnum(String descricao) {
        this.descricao = descricao;
    }
}
