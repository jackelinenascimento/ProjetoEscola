package br.com.jsn.escola.academico.dominio.aluno;

import java.util.List;

import br.com.jsn.escola.shared.dominio.CPF;

public interface RepositorioDeAlunos {

	void matricular(Aluno aluno);
	
	Aluno buscarPorCPF(CPF cpf);
	
	List<Aluno> listarTodosAlunosMatriculados();
	
}
