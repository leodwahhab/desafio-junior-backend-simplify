package com.example.desafiojuniorbackendsimplify.exception;

public class TarefaJaExistenteException extends RuntimeException {
    public TarefaJaExistenteException() {
        super("Já existe uma tarefa pendente com esse nome!");
    }
}
