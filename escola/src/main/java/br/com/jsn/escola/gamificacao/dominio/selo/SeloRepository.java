package br.com.jsn.escola.gamificacao.dominio.selo;

import java.util.List;

import br.com.jsn.escola.academico.dominio.aluno.CPF;

public interface SeloRepository {
	
	void adicionar(Selo selo);
	
	List<Selo> selosDoAlunoDeCPF(CPF cpf);

}
