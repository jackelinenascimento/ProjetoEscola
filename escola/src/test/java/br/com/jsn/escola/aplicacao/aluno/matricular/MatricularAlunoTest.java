package br.com.jsn.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.jsn.escola.dominio.aluno.CPF;
import br.com.jsn.escola.dominio.aluno.exception.AlunoNaoEncontrado;
import br.com.jsn.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio);

		MatricularAlunoDto dados = new MatricularAlunoDto("nomeAluno", "123.456.789-12", "email@email.com");
	
		useCase.matricular(dados);
		
		assertNotNull(repositorio.buscarPorCPF(new CPF("123.456.789-12")));
		
	}
	
	@Test
	void alunoNaoDeveriaSerPersistido() {
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio);

		MatricularAlunoDto dados = new MatricularAlunoDto("nomeAluno", "123.456.789-12", "");

		assertThrows(IllegalArgumentException.class, 
				() -> useCase.matricular(dados));
		
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
