package br.com.jsn.escola.gamificacao.aplicacao;

import br.com.jsn.escola.gamificacao.dominio.selo.Selo;
import br.com.jsn.escola.shared.RepositorioDeSelos;
import br.com.jsn.escola.shared.dominio.CPF;
import br.com.jsn.escola.shared.dominio.evento.Evento;
import br.com.jsn.escola.shared.dominio.evento.OuvinteEvento;
import br.com.jsn.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends OuvinteEvento{

	private final RepositorioDeSelos repositorioDeSelos;
	
	public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
		this.repositorioDeSelos = repositorioDeSelos;
		}
	
	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
	}

	@Override
	protected void reageAo(Evento evento) {
		CPF cpf = (CPF) evento.informacoes().get("cpf");
		Selo novato = new Selo(cpf, "Novato");
		repositorioDeSelos.adicionar(novato);	
	}

}
