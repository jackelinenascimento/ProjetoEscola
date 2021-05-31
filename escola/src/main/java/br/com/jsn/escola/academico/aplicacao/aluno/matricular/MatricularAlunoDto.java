package br.com.jsn.escola.academico.aplicacao.aluno.matricular;

import br.com.jsn.escola.academico.dominio.aluno.Aluno;
import br.com.jsn.escola.academico.dominio.aluno.CPF;
import br.com.jsn.escola.academico.dominio.aluno.Email;

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
