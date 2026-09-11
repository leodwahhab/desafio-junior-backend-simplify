package com.example.desafiojuniorbackendsimplify.model;

import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private PrioridadeEnum prioridade;
}
