package escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
