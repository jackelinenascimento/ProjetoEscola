package br.com.jsn.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.jsn.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.jsn.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.jsn.escola.academico.dominio.PublicadorDeEventos;
import br.com.jsn.escola.academico.dominio.aluno.CPF;
import br.com.jsn.escola.academico.dominio.aluno.exception.AlunoNaoEncontrado;
import br.com.jsn.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

@RunWith(MockitoJUnitRunner.class)
class MatricularAlunoTest {
	
	@Mock
	private PublicadorDeEventos publicador; 

	@Test
	void alunoDeveriaSerPersistido() {
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

		MatricularAlunoDto dados = new MatricularAlunoDto("nomeAluno", "123.456.789-12", "email@email.com");
	
		useCase.executa(dados);
		
		assertNotNull(repositorio.buscarPorCPF(new CPF("123.456.789-12")));
		
	}
	
	@Test
	void alunoNaoDeveriaSerPersistido() {
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

		MatricularAlunoDto dados = new MatricularAlunoDto("nomeAluno", "123.456.789-12", "");

		assertThrows(IllegalArgumentException.class, 
				() -> useCase.executa(dados));
		
	}
	
	@Test
	void deveMostrarExceptionDeAlunoNaoEncontrado() {
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		assertThrows(AlunoNaoEncontrado.class,
				() -> {
					repositorio.buscarPorCPF(new CPF("123.456.789-12"));
				});
		}

}
