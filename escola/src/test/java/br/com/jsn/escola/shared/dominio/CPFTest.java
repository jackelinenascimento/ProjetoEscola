package br.com.jsn.escola.shared.dominio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.jsn.escola.shared.dominio.CPF;

class CPFTest {

	@Test
	void naoDeveCriarCPFComDadosInvalidos() {
		
		assertThrows(IllegalArgumentException.class,
				() -> new CPF(null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new CPF(""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new CPF("122333"));
		
	}

}
