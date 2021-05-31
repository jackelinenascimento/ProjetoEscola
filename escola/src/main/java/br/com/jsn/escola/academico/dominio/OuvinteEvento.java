package br.com.jsn.escola.academico.dominio;

public abstract class OuvinteEvento {

	public void processa(Evento evento) {
		
		if (this.deveProcessar(evento)) {
			this.reageAo(evento);
		}
	}
	
	protected abstract boolean deveProcessar(Evento evento);
	protected abstract void reageAo(Evento evento);
}
