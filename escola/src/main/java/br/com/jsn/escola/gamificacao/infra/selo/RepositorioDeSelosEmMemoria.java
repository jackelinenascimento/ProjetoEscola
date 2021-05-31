package br.com.jsn.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.jsn.escola.academico.dominio.aluno.CPF;
import br.com.jsn.escola.gamificacao.dominio.selo.Selo;
import br.com.jsn.escola.gamificacao.dominio.selo.SeloRepository;

public class RepositorioDeSelosEmMemoria implements SeloRepository{

	public List<Selo> selos = new ArrayList<>();
	
	@Override
	public void adicionar(Selo selo) {
		selos.add(selo);
		
	}

	@Override
	public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
		return this.selos
					.stream()
					.filter(s -> s.getCpfDoAluno().equals(cpf))
					.collect(Collectors.toList());
	}

}
