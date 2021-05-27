package br.com.jsn.escola.dominio.aluno;

//Servico de Dominio

public interface CifradorDeSenha {

	String cifrarSenha(String senha);
	
	boolean validarSenhaCifrada(String senhaCifrada, String senha);
	
}
