package br.com.jsn.escola.academico.dominio.aluno;

import br.com.jsn.escola.shared.dominio.CPF;

// builder pattern

public class AlunoFactory {
	
	private Aluno aluno;
	
	public AlunoFactory comNomeCPFEmail(String nome, String cpf, String email) {	
		this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
		return this;
	}
	
	public AlunoFactory comTelefone(String ddd, String numero) {
		try {
			this.aluno.adicionarTelefone(ddd, numero);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public Aluno criar() {
		return this.aluno;
	}

}
