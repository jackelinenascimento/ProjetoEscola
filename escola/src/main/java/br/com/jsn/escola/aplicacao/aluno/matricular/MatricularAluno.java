package br.com.jsn.escola.aplicacao.aluno.matricular;

import br.com.jsn.escola.dominio.aluno.Aluno;
import br.com.jsn.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
	
	private final RepositorioDeAlunos repositorio;
	
	public MatricularAluno(RepositorioDeAlunos repositorio) {
		this.repositorio = repositorio;
	}
	
	public void matricular(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
	}
	
}
