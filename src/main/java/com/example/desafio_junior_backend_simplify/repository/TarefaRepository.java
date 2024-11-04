package com.example.desafio_junior_backend_simplify.repository;

import com.example.desafio_junior_backend_simplify.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    Tarefa save(Tarefa tarefa);

    void deleteById(Long id);
}
