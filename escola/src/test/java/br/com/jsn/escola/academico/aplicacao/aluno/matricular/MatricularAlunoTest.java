package br.com.jsn.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.jsn.escola.academico.dominio.aluno.LogAlunoMatriculado;
import br.com.jsn.escola.academico.dominio.aluno.exception.AlunoNaoEncontrado;
import br.com.jsn.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.jsn.escola.shared.dominio.CPF;
import br.com.jsn.escola.shared.dominio.evento.OuvinteEvento;
import br.com.jsn.escola.shared.dominio.evento.PublicadorDeEventos;

@RunWith(MockitoJUnitRunner.class)
class MatricularAlunoTest {

	@Test
	void alunoNaoDeveriaSerPersistido() {

		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();

		OuvinteEvento ouvinte = new LogAlunoMatriculado();

		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(ouvinte);

		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

		MatricularAlunoDto dados = new MatricularAlunoDto("nomeAluno", "423.456.789-12", "");

		assertThrows(IllegalArgumentException.class, () -> useCase.executa(dados));

	}

	@Test
	void deveMostrarExceptionDeAlunoNaoEncontrado() {

		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();

		assertThrows(AlunoNaoEncontrado.class, () -> {
			repositorio.buscarPorCPF(new CPF("723.456.789-12"));
		});
	}

}
