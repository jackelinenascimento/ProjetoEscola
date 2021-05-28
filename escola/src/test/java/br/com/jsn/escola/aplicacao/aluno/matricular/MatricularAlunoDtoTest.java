package br.com.jsn.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MatricularAlunoDtoTest {

	@Test
	void deveCriarObjetoDoTipoAluno() {
		
		MatricularAlunoDto m = new MatricularAlunoDto("nomeAluno", "111.222.333-44", "email@email.com");	
		assertNotNull(m.criarAluno());
	}
}
