package br.com.jsn.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.jsn.escola.academico.dominio.aluno.exception.NumeroMaximoDeTelefonesCadastrados;
import br.com.jsn.escola.shared.dominio.CPF;

//Aggregate root

public class Aluno {
	
	private CPF cpf;
	private String nome;
	
	private Email email;

	private List<Telefone> telefones = new ArrayList<>();

	private String senha;

	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(String ddd, String numero) throws RuntimeException {
		//invariante
		if(telefones.size() == 2) {
			throw new NumeroMaximoDeTelefonesCadastrados();
		}
		this.telefones.add(new Telefone(ddd, numero));
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public String getSenha() {
		return senha;
	}
	
}
