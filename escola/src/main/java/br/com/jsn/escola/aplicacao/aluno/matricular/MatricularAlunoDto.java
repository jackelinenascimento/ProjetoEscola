package br.com.jsn.escola.aplicacao.aluno.matricular;

import br.com.jsn.escola.dominio.aluno.Aluno;
import br.com.jsn.escola.dominio.aluno.CPF;
import br.com.jsn.escola.dominio.aluno.Email;

public class MatricularAlunoDto {
	
	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	
	public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}
	
	public Aluno criarAluno() {
		return new Aluno(new CPF(this.cpfAluno), this.nomeAluno, new Email(this.emailAluno));
	}

}
