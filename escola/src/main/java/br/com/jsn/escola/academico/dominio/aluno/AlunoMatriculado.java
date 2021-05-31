package br.com.jsn.escola.academico.dominio.aluno;

import java.time.LocalDateTime;

import br.com.jsn.escola.academico.dominio.Evento;

public class AlunoMatriculado implements Evento {

	private final CPF cpfDoAluno;
	private final LocalDateTime momento;
	
	public AlunoMatriculado(CPF cpfDoAluno) {
		this.cpfDoAluno = cpfDoAluno;
		this.momento = LocalDateTime.now();
	}

	@Override
	public LocalDateTime momento() {
		return momento;
	}

	public CPF getCpfDoAluno() {
		return cpfDoAluno;
	}

	public LocalDateTime getMomento() {
		return momento;
	}
}
