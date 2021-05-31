package br.com.jsn.escola.academico.aplicacao;

import br.com.jsn.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);

}
