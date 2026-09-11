package com.example.desafiojuniorbackendsimplify.controller;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
import com.example.desafiojuniorbackendsimplify.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<?> criarTarefa(@RequestBody TarefaRequestDto tarefaRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefaRequestDto));
    }

    @GetMapping()
    public ResponseEntity<?> getTarefas(@RequestParam(required = false) String nome,
                                        @RequestParam(required = false) String descricao,
                                        @RequestParam(required = false) Boolean realizado,
                                        @RequestParam(required = false) PrioridadeEnum prioridade) {
        TarefaRequestDto requestDto = new TarefaRequestDto(nome, descricao, realizado, prioridade);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.listarTarefas(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTarefa(@PathVariable Long id, @RequestBody TarefaRequestDto tarefaRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.atualizarTarefa(id, tarefaRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirTarefa(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
