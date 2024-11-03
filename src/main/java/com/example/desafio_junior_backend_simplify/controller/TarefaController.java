package com.example.desafio_junior_backend_simplify.controller;

import com.example.desafio_junior_backend_simplify.dto.TarefaDTO;
import com.example.desafio_junior_backend_simplify.service.TarefaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @GetMapping("/")
    public ResponseEntity<List<TarefaDTO>> buscarTarefas() {
        return ResponseEntity.ok(tarefaService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/").buildAndExpand().toUri())
                .body(tarefaService.createTarefa(tarefaDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> alterarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        return ResponseEntity.ok().body(tarefaService.atualizarTarefa(id,  tarefaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirTarefa(@PathVariable Long id) throws Exception {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
