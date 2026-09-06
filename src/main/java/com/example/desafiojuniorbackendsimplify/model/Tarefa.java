package com.example.desafiojuniorbackendsimplify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "tarefa")
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private boolean realizado = false;

    @Column(nullable = false)
    private Prioridade prioridade;

    @Getter
    enum Prioridade {
        BAIXA("Baixa"),
        MEDIa("Média"),
        ALTA("Alta");

        private final String descricao;

        Prioridade(String descricao) {
            this.descricao = descricao;
        }

    }
}
