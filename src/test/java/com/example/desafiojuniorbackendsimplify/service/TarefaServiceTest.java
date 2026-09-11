package com.example.desafiojuniorbackendsimplify.service;

import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaRequestDto;
import com.example.desafiojuniorbackendsimplify.controller.dto.TarefaResponseDto;
import com.example.desafiojuniorbackendsimplify.enums.PrioridadeEnum;
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
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.example.desafiojuniorbackendsimplify.constants.TarefaContants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
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
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(TAREFA_VALIDO_01);

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

    @Test
    public void listarTarefas_ComFiltroValido_RetornaTarefasFiltradas() {
        when(tarefaRepository.findAll(any(Specification.class))).thenReturn(LISTA_TAREFAS_FILTRADA);

        List<TarefaResponseDto> sut = tarefaService.listarTarefas(REQUEST_VALIDO);

        assertThat(sut.isEmpty()).isFalse();
        assertThat(sut.size()).isEqualTo(1);
        assertThat(sut.getFirst().nome()).isEqualTo(REQUEST_VALIDO.nome());
        assertThat(sut.getFirst().descricao()).isEqualTo(REQUEST_VALIDO.descricao());
        assertThat(sut.getFirst().realizado()).isEqualTo(REQUEST_VALIDO.realizado());
        assertThat(sut.getFirst().prioridade()).isEqualTo(REQUEST_VALIDO.prioridade());
    }

    @Test
    public void listarTarefas_SemFiltro_RetornaTodasTarefas() {
        when(tarefaRepository.findAll(any(Specification.class))).thenReturn(LISTA_TAREFAS);

        List<TarefaResponseDto> sut = tarefaService.listarTarefas(REQUEST_NULL);

        assertThat(sut.isEmpty()).isFalse();
        assertThat(sut.size()).isEqualTo(3);
        assertThat(sut.getFirst()).isEqualTo(RESPONSE_VALIDO);
    }

    @Test
    public void listarTarefas_SemRegistros_RetornaListaVazia() {
        when(tarefaRepository.findAll(any(Specification.class))).thenReturn(List.of());

        List<TarefaResponseDto> sut = tarefaService.listarTarefas(REQUEST_VALIDO);

        assertThat(sut.isEmpty()).isTrue();
    }

    @Test
    public void atualizarTarefa_ComDadosValidos_RetornaTarefaAtualizada() {
        when(tarefaRepository.findById(anyLong())).thenReturn(Optional.of(TAREFA_VALIDO_01));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(TAREFA_VALIDO_02);
        String novoNome = TAREFA_VALIDO_02.getNome();
        String novoDescricao = TAREFA_VALIDO_02.getDescricao();
        Boolean novoRealizado = TAREFA_VALIDO_02.isRealizado();
        PrioridadeEnum novoPrioridade = TAREFA_VALIDO_02.getPrioridade();
        TarefaRequestDto exemploTarefaAtualizada = new TarefaRequestDto(novoNome, novoDescricao, novoRealizado, novoPrioridade);

        TarefaResponseDto sut = tarefaService.atualizarTarefa(1L, exemploTarefaAtualizada);

        assertThat(sut).isNotNull();
        assertThat(sut.nome()).isEqualTo(novoNome);
        assertThat(sut.descricao()).isEqualTo(novoDescricao);
        assertThat(sut.realizado()).isEqualTo(novoRealizado);
        assertThat(sut.prioridade()).isEqualTo(novoPrioridade);
    }

    @Test
    public void atualizarTarefa_ComIdInexistente_LancaExcecao() {
        when(tarefaRepository.findById(anyLong())).thenThrow(NoSuchElementException.class);

        assertThrows(NoSuchElementException.class, () -> tarefaService.atualizarTarefa(1L, REQUEST_VALIDO));
    }

    @Test
    public void atualizarTarefa_ComDadosInvalidos_LancaExcecao() {
        when(tarefaRepository.findById(anyLong())).thenReturn(Optional.of(TAREFA_VALIDO_01));
        when(tarefaRepository.save(any(Tarefa.class))).thenThrow(DataIntegrityViolationException.class);

        assertThrows(DataIntegrityViolationException.class, () -> tarefaService.atualizarTarefa(1L, REQUEST_EMPTY));
        assertThrows(DataIntegrityViolationException.class, () -> tarefaService.atualizarTarefa(1L, REQUEST_BLANK));
        assertThrows(DataIntegrityViolationException.class, () -> tarefaService.atualizarTarefa(1L, REQUEST_NULL));
    }
}
