package com.example.desafio_junior_backend_simplify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private boolean realizado;

    private int prioridade;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public boolean estaRealizado() {
        return realizado;
    }
}
