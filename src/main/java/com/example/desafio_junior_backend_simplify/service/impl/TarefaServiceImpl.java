package com.example.desafio_junior_backend_simplify.service.impl;

import com.example.desafio_junior_backend_simplify.dto.TarefaDTO;
import com.example.desafio_junior_backend_simplify.model.Tarefa;
import com.example.desafio_junior_backend_simplify.repository.TarefaRepository;
import com.example.desafio_junior_backend_simplify.service.TarefaService;
import com.example.desafio_junior_backend_simplify.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<TarefaDTO> listarTarefas(Long usuarioId) {
//        if(Objects.nonNull(usuarioId) && usuarioRepository.existsById(usuarioId)) {
//
//        }
        return null;
    }

    public TarefaDTO criarTarefa(String email, String senha, TarefaDTO tarefaDTO) {
        if(usuarioService.validarLogin(email, senha)) {
            Tarefa tarefa = new Tarefa();

            BeanUtils.copyProperties(tarefaDTO, tarefa);

            tarefaRepository.save(tarefa);
        }
        else
            throw new IllegalArgumentException();

        return tarefaDTO;
    }

//    public TarefaDTO atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
//        Tarefa tarefa = new Tarefa(
//                id,
//                tarefaDTO.nome(),
//                tarefaDTO.descricao(),
//                tarefaDTO.realizado(),
//                tarefaDTO.prioridade()
//        );
//
//        tarefaRepository.save(tarefa);
//
//        return tarefaDTO;
//    }

    public void excluirTarefa(Long id) {
        if(tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        }
//        else
//            throw new Exception("id não identificado");
    }
}
