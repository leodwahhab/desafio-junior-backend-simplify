package com.example.desafiojuniorbackendsimplify.repository;

import com.example.desafiojuniorbackendsimplify.model.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import static com.example.desafiojuniorbackendsimplify.constants.TarefaContants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class TarefaRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void criarTarefa_ComDadosValidos_RetornaTarefa() {
        Tarefa example = tarefaRepository.save(TAREFA_VALIDO_01);
        Tarefa sut = entityManager.find(Tarefa.class, example.getId());

        assertThat(sut).isNotNull();
        assertThat(sut.getNome()).isEqualTo(TAREFA_VALIDO_01.getNome());
        assertThat(sut.getDescricao()).isEqualTo(TAREFA_VALIDO_01.getDescricao());
        assertThat(sut.getPrioridade()).isEqualTo(TAREFA_VALIDO_01.getPrioridade());
    }

    @Test
    public void criarTarefa_ComDadosInvalidos_LancaExcecao() {
        assertThatThrownBy(() -> tarefaRepository.save(TAREFA_BLANK)).isInstanceOf(DataIntegrityViolationException.class);
        assertThatThrownBy(() -> tarefaRepository.save(TAREFA_EMPTY)).isInstanceOf(DataIntegrityViolationException.class);
        assertThatThrownBy(() -> tarefaRepository.save(TAREFA_NULL)).isInstanceOf(DataIntegrityViolationException.class);
    }
}
