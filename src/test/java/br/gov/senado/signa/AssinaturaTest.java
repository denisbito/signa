package br.gov.senado.signa;

import junit.framework.Assert;

import org.junit.Test;

public class AssinaturaTest {

	@Test
	public void testarCriarAssinaturaEDefinirSeuTipo() {
		Assinatura assinatura = new Assinatura();
		assinatura.setTipo(TipoAssinatura.PKC7S);
		Assert.assertEquals(TipoAssinatura.PKC7S, assinatura.getTipo());
	}

}
