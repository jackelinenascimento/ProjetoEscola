package br.com.jsn.escola.aplicacao;

import br.com.jsn.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);

}
