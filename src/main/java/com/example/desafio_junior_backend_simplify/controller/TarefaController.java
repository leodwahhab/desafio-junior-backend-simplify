package com.example.desafio_junior_backend_simplify.controller;

import com.example.desafio_junior_backend_simplify.dto.TarefaDTO;
import com.example.desafio_junior_backend_simplify.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @GetMapping("/{id}")
    public ResponseEntity<List<TarefaDTO>> listarTarefas(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.listarTarefas(id));
    }

    @PostMapping("/{email}&{senha}")
    public ResponseEntity<TarefaDTO> criarTarefa(@PathVariable String email, @PathVariable String senha, @RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand().toUri())
                .body(tarefaService.criarTarefa(email, senha, tarefaDTO));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TarefaDTO> alterarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
//        return ResponseEntity.ok().body(tarefaService.atualizarTarefa(id,  tarefaDTO));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirTarefa(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
