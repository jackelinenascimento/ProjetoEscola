package br.com.jsn.escola.academico.dominio.aluno.exception;

public class NumeroMaximoDeTelefonesCadastrados extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumeroMaximoDeTelefonesCadastrados() {
		System.out.println("N�mero maximo de telefones cadastrados foi atingido."
				+ " Cada aluno pode ter no maximo 2 telefones cadastrados.");
		
	}
}
