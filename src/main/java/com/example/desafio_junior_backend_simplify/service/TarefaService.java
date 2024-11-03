package com.example.desafio_junior_backend_simplify.service;

import com.example.desafio_junior_backend_simplify.dto.TarefaDTO;
import com.example.desafio_junior_backend_simplify.model.Tarefa;
import com.example.desafio_junior_backend_simplify.repository.TarefaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;

    public List<TarefaDTO> getAll() {
        List<TarefaDTO> tarefasResponse = new ArrayList<TarefaDTO>();
        List<Tarefa> tarefas = tarefaRepository.findAll();


        tarefas.forEach(tarefa -> {
            tarefasResponse.add(new TarefaDTO(
                    tarefa.getNome(),
                    tarefa.getDescricao(),
                    tarefa.getRealizado(),
                    tarefa.getPrioridade()
            ));
        });

        return tarefasResponse;
    }

    public TarefaDTO createTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();

        BeanUtils.copyProperties(tarefaDTO, tarefa);

        tarefaRepository.save(tarefa);

        return tarefaDTO;
    }

    public TarefaDTO atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa(
                id,
                tarefaDTO.nome(),
                tarefaDTO.descricao(),
                tarefaDTO.realizado(),
                tarefaDTO.prioridade()
        );

        tarefaRepository.save(tarefa);

        return tarefaDTO;
    }

    public void excluirTarefa(Long id) throws Exception {
        if(tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        }
        else
            throw new Exception("id não identificado");
    }
}
