package br.com.jsn.escola.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.jsn.escola.aluno.Email;

class EmailTest {

	@Test
	void naoDeveCriarEmailsComEnderecosInvalidos() {
		
		assertThrows(IllegalArgumentException.class,
				() -> new Email(null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Email(""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Email("emailinvalido"));
	}

}
