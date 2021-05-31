package br.com.jsn.escola.academico.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.jsn.escola.shared.dominio.evento.Evento;
import br.com.jsn.escola.shared.dominio.evento.OuvinteEvento;

public class LogAlunoMatriculado  extends OuvinteEvento{

	@Override
	public void reageAo(Evento evento) {
		
		String momentoFormatado = ((AlunoMatriculado) evento)
								  .getMomento()
								  .format(DateTimeFormatter
								  .ofPattern("dd//MM//yyyy HH:mm"));
		
		System.out.println(
				String.format("Aluno com CPF %s matriculado em: %s",
						 ((AlunoMatriculado) evento).getCpfDoAluno(),
						 momentoFormatado));	
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}	
}
