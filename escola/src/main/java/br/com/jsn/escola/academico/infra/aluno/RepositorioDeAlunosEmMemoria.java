package br.com.jsn.escola.academico.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.jsn.escola.academico.dominio.aluno.Aluno;
import br.com.jsn.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.jsn.escola.academico.dominio.aluno.exception.AlunoNaoEncontrado;
import br.com.jsn.escola.shared.dominio.CPF;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
