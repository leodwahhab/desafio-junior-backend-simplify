package com.example.desafiojuniorbackendsimplify.repository;

import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    boolean existsByNomeAndRealizadoFalse(String name);
}
