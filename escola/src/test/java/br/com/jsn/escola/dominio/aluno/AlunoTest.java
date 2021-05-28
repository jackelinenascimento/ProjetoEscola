package br.com.jsn.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.jsn.escola.dominio.aluno.exception.NumeroMaximoDeTelefonesCadastrados;

class AlunoTest {
	
	private Aluno aluno;

	@BeforeEach
	void beforeEach() {
		this.aluno = new Aluno(
				new CPF("123.456.789-12"),
				"Fulano",
				new Email("fulano@email.com"));
	}
	
	@Test
	void deveAdicionarTelefone() {
		
		aluno.adicionarTelefone("12", "12345678");
		assertEquals(1, aluno.getTelefones().size());
		
	}
	
	@Test
	void devePermitirAdicionar2Telefones() {
		
		aluno.adicionarTelefone("12", "123456778");
		aluno.adicionarTelefone("11", "123443213");
		
		assertEquals(2, aluno.getTelefones().size());
	}
	
	@Test
	void naoDevePermitirAdicionar3Telefones() {
		
		assertThrows(NumeroMaximoDeTelefonesCadastrados.class,
				() -> {
		aluno.adicionarTelefone("12", "123456778");
		aluno.adicionarTelefone("11", "123443213");
		aluno.adicionarTelefone("12", "123456778");
		aluno.adicionarTelefone("11", "123443213");
		});
	}

}
