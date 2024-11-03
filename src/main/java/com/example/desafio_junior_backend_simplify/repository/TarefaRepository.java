package com.example.desafio_junior_backend_simplify.repository;

import com.example.desafio_junior_backend_simplify.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query(value =
        "   SELECT  " +
        "       *   " +
        "   FROM    " +
        "       tarefas    ", nativeQuery = true)
    public List<Tarefa> getAllTarefa();

    public Tarefa save(Tarefa tarefa);

    public void deleteById(Long id);
}
