package com.example.desafiojuniorbackendsimplify.service;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.exception.TarefaJaExistenteException;
import com.example.desafiojuniorbackendsimplify.mapper.TarefaMapper;
import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import com.example.desafiojuniorbackendsimplify.repository.TarefaRepository;
import com.example.desafiojuniorbackendsimplify.service.impl.TarefaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import static com.example.desafiojuniorbackendsimplify.constants.TarefaContants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @InjectMocks
    private TarefaServiceImpl tarefaService;

    @Mock
    private TarefaRepository tarefaRepository;

    @Spy
    private TarefaMapper tarefaMapper;

    @Test
    public void criarTarefa_ComDadosValidos_RetornaTarefa() {
        when(tarefaRepository.existsByNomeAndRealizadoFalse(anyString())).thenReturn(false);
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(TAREFA_VALIDO);

        TarefaResponseDto sut = tarefaService.criarTarefa(REQUEST_VALIDO);
        TarefaResponseDto sutDescricaoRealizadoNulos = tarefaService.criarTarefa(REQUEST_VALIDO_CAMPOS_NULOS);

        assertThat(sut).isEqualTo(RESPONSE_VALIDO);
        assertThat(sutDescricaoRealizadoNulos).isEqualTo(RESPONSE_VALIDO);
    }

    @Test
    public void criarTarefa_JaExistenteNaoRealizada_LancaExcecao() {
        when(tarefaRepository.existsByNomeAndRealizadoFalse(REQUEST_VALIDO.nome())).thenReturn(true);

        assertThrows(TarefaJaExistenteException.class, () -> tarefaService.criarTarefa(REQUEST_VALIDO));
    }

    @Test
    public void criarTarefa_ComDadosInvalidos_LancaExcecao() {
        when(tarefaRepository.save(any(Tarefa.class))).thenThrow(DataIntegrityViolationException.class);

        assertThrows(DataIntegrityViolationException.class, () -> tarefaService.criarTarefa(REQUEST_EMPTY));
        assertThrows(DataIntegrityViolationException.class, () -> tarefaService.criarTarefa(REQUEST_BLANK));
        assertThrows(DataIntegrityViolationException.class, () -> tarefaService.criarTarefa(REQUEST_NULL));
    }
}
