package br.gov.senado.signa;

/**
 * Assinatura digital gerada a partir de um arquivo.
 * 
 * @author Denis Oliveira.
 */
public class Signature {

	private TipoAssinatura tipo;

	public TipoAssinatura getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoAssinatura tipoAssinatura) {
		this.tipo = tipoAssinatura;
	}

}
