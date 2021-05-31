package br.com.jsn.escola.academico.dominio.aluno.exception;

import br.com.jsn.escola.shared.dominio.CPF;

public class AlunoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontrado(CPF cpf) {
		System.out.println("Aluno com CPF: " + cpf.getNumero() + " não encontrado.");
	}
}
