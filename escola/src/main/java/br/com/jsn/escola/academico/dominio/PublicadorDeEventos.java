package br.com.jsn.escola.academico.dominio;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {
	
	private List<OuvinteEvento> ouvintes = new ArrayList<>();
	
	public void adicionar(OuvinteEvento ouvinte) {
		this.ouvintes.add(ouvinte);
	}
	
	public void publicar(Evento evento) {
		this.ouvintes.forEach(o -> {
			o.processa(evento);
		});
	}
}
