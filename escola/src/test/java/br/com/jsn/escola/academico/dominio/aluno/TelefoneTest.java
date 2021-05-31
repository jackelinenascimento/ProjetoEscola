package br.com.jsn.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.jsn.escola.academico.dominio.aluno.Telefone;

class TelefoneTest {

	@Test
	void naoDeveCriarTelefoneComDadosInvalidos() {
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone(null, null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("",""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Telefone("12", "12345"));
		
	}

}
