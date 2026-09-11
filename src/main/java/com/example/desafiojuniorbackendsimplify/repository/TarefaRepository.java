package com.example.desafiojuniorbackendsimplify.repository;

import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>, JpaSpecificationExecutor<Tarefa> {
    boolean existsByNomeAndRealizadoFalse(String name);
}
